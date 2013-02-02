package cs588.ui.tructrac;

import java.lang.reflect.Field;
import java.util.List;


import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Augmented extends  ListActivity implements OnClickListener 
{
	private TruckAdapter truckadapter;
	String trucknames;

	int previous=0;
	float[] accelerometerValues=new float[3];
	float[] magneticValues=new float[3];
	float values[]=new float[3];
	float[] R1=new float[9];
	double[] lat={34.033155,34.030131,34.034773};
	double[] lng={-118.288808,-118.290482,-118.285568};
	private static class ViewHolder
	{
		ImageView iv;
		TextView nametv;
		RatingBar rb;
		TextView street;
		TextView city;
		TextView distance;
		ImageView status;
	}
	List<Truck> rettv;
	 private SurfaceView preview=null;
	  private SurfaceHolder previewHolder=null;
	  private Camera camera=null;
	  private boolean inPreview=false;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.augmented);
     
        SensorManager sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor asensor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor mfsensor=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(myOr,asensor,SensorManager.SENSOR_DELAY_UI);
        sm.registerListener(mymOr,mfsensor,SensorManager.SENSOR_DELAY_UI);
        preview=(SurfaceView)findViewById(R.id.preview);
        previewHolder=preview.getHolder();
        previewHolder.addCallback(surfaceCallback);
        previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        truckadapter=new TruckAdapter();
        setListAdapter(truckadapter);
       /* System.out.println(getQuadrant(lat[0],lng[0],lat[1],lng[1]));
        System.out.println(getQuadrant(lat[0],lng[0],lat[2],lng[2]));*/
//        System.out.println(getQuadrant(lat[0],lng[0],lat[3],lng[3]));

    
    }
    @Override
    public void onResume() {
      super.onResume();
      
      camera=Camera.open();
    }
      
    @Override
    public void onPause() {
      if (inPreview) {
        camera.stopPreview();
      }
      
      camera.release();
      camera=null;
      inPreview=false;
            
      super.onPause();
    }
    
    private Camera.Size getBestPreviewSize(int width, int height,
                                           Camera.Parameters parameters) {
      Camera.Size result=null;
      
      for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
        if (size.width<=width && size.height<=height) {
          if (result==null) {
            result=size;
          }
          else {
            int resultArea=result.width*result.height;
            int newArea=size.width*size.height;
            
            if (newArea>resultArea) {
              result=size;
            }
          }
        }
      }
      
      return(result);
    }
    
    SurfaceHolder.Callback surfaceCallback=new SurfaceHolder.Callback() {
      public void surfaceCreated(SurfaceHolder holder) {
        try {
          camera.setPreviewDisplay(previewHolder);
        }
        catch (Throwable t) {
          Log.e("PreviewDemo-surfaceCallback",
                "Exception in setPreviewDisplay()", t);
          Toast
            .makeText(Augmented.this, t.getMessage(), Toast.LENGTH_LONG)
            .show();
        }
      }
      
      public void surfaceChanged(SurfaceHolder holder,
                                 int format, int width,
                                 int height) {
        Camera.Parameters parameters=camera.getParameters();
        Camera.Size size=getBestPreviewSize(width, height,
                                            parameters);
        
        if (size!=null) {
          parameters.setPreviewSize(size.width, size.height);
          camera.setParameters(parameters);
          camera.setDisplayOrientation(90);
          camera.startPreview();
          inPreview=true;
        }
      }
      
      public void surfaceDestroyed(SurfaceHolder holder) {
        // no-op
      }
    };
    private class TruckAdapter extends BaseAdapter   
	{

		public int getCount() 
		{
			if(rettv!=null)
			return rettv.size();
			else
				return 0;
			
		}

		public Truck getItem(int position) 
		{
			
			return rettv.get(position);
		}

		public long getItemId(int position) 
		{
			return position;
		}

		public View getView(int position, View arg1, ViewGroup arg2) 
		{
			View v=arg1;
			ViewHolder vh;
			if(v==null)
			{
				 vh=new ViewHolder();
	             LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	             v = vi.inflate(R.layout.rowinlist, null);  
	             vh.iv=(ImageView)v.findViewById(R.id.truckimage);
	             vh.street=(TextView)v.findViewById(R.id.street);
	             vh.city=(TextView)v.findViewById(R.id.city);
	             vh.rb=(RatingBar)v.findViewById(R.id.ratingbar);
	             vh.nametv=(TextView)v.findViewById(R.id.name);
	             vh.distance=(TextView)v.findViewById(R.id.distance);
	             vh.status=(ImageView)v.findViewById(R.id.status);
	             v.setTag(vh);
			}
			else
			{
				vh=(ViewHolder)arg1.getTag();
			}
			
			trucknames=rettv.get(position).name;
			try 
			{
				int drawableId;
			    Class res = R.drawable.class;
			    Field field = res.getField(trucknames);
			    drawableId = field.getInt(null);
				vh.iv.setImageResource(drawableId);

			}
			catch (Exception e) 
			{
			    Log.e("MyTag", "Failure to get drawable id.", e);
			}
//			System.out.println(rettv.get(position).name);
			vh.nametv.setText(rettv.get(position).name);
			vh.street.setText(rettv.get(position).street);
			vh.rb.setRating(rettv.get(position).rating);
			vh.city.setText(rettv.get(position).city);
			vh.distance.setText(rettv.get(position).miles+"miles");
			if(rettv.get(position).status)
			{
				vh.status.setImageResource(R.drawable.greendot);	
			}
			else
				vh.status.setImageResource(R.drawable.rd);
			return v;
		
			
			
		}
		
		
	}
    int getQuadrantAugmented(float degrees)
    {
    	if(degrees>=0&&degrees<=90)
    		return 2;
    	if(degrees>90&&degrees<=180)
    		return 1;
    	if(degrees>180&&degrees<=270)
    		return 4;
    	if(degrees>=-90&&degrees<0)
    		return 3;
    	return 0;
    }
    int getQuadrant(double lat1,double lng1,double lat2,double lng2)
    {
    	double x1=180+lng1;
    	double y1=90-lat1;
    	double x2=180+lng2;
    	double y2=90-lat2;
    	if((x2-x1)>0&&(y2-y1)>0)
    		return 3;
    	if((x2-x1)>0&&(y2-y1)<0)
    		return 2;
    	if((x2-x1)<0&&(y2-y1)<0)
    		return 1;
    	if((x2-x1)<0&&(y2-y1)>0)
    		return 4;
    	if((x2-x1)==0&&(y2<y1))
    		return 1;
    	if((x2-x1)==0&&(y2>y1))
    		return 2;
     	if((y2-y1)==0&&(x2>x1))
    		return 2;
     	if((y2-y1)==0&&(x2<x1))
    		return 1;
    	return 0;
    }
    double getAngle(double lat1,double lng1,double lat2,double lng2)
    {
    	double x1=180+lng1;
    	double y1=90-lat1;
    	double x2=180+lng2;
    	double y2=90-lat2;
    	double slope=(y2-y1)/(x2-x1);
    	double degrees=Math.toDegrees(Math.atan(slope));
    	
    	return degrees;
    }
    
    final SensorEventListener myOr=new SensorEventListener() {
    	public void onSensorChanged(SensorEvent sensorEvent)
    	{
    		if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
    		{
    			accelerometerValues=sensorEvent.values;
    			updateOrientation();
    		}
    	}
    	public void onAccuracyChanged(Sensor sensor, int accuracy)
    	{
    		
    	}
    };
    final SensorEventListener mymOr=new SensorEventListener() {
    	public void onSensorChanged(SensorEvent sensorEvent)
    	{
    		if(sensorEvent.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD)
    		{
    			magneticValues=sensorEvent.values;
    			updateOrientation();

    		}
    	}
    	public void onAccuracyChanged(Sensor sensor, int accuracy)
    	{
    		
    	}
    };
    public void updateOrientation()
    {
    	SensorManager.getRotationMatrix(R1,null, accelerometerValues, magneticValues);
    	float[] outR=new float[9];
    	SensorManager.remapCoordinateSystem(R1, SensorManager.AXIS_X, SensorManager.AXIS_Z, outR);
    	SensorManager.getOrientation(outR, values);
    	values[0]=(float)Math.toDegrees(values[0]);
    	values[1]=(float)Math.toDegrees(values[1]);
    	values[2]=(float)Math.toDegrees(values[2]);
    	float degrees=-(values[0]-90);
	//TruckList.getInstance().getTruckDetails("", 4, degrees,0);
    	//tv.setText(getAzimuth(l2,l1)+"x");
    	if(getQuadrantAugmented(degrees)!=previous)
    	{	
  		rettv=TruckList.getInstance().getTruckDetails("", 4, 0,0,degrees);
  		previous=getQuadrantAugmented(degrees);
   		truckadapter.notifyDataSetChanged();
    //		System.out.println(getQuadrantAugmented(degrees));
    	}
  
    }
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
 
}