package cs588.ui.tructrac;


import java.lang.reflect.Field;
import java.util.List;

import cs588.ui.tructracobjects.GlobalValues;
import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Cusines extends ListActivity implements OnClickListener{
    /** Called when the activity is first created. */
	private TruckAdapter truckadapter;
	boolean searchbuttonclicked=false;

	TruckList td;
	List<Truck> rettv;
	String trucknames;
	String search;
	TextView searchview;
	String cuisine;
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
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.trucklist);
        showDialog(0);
        searchview=(TextView)findViewById(R.id.searchbox);
        td=td.getInstance();
//        rettv=td.getInstance().getTruckDetails("", 1,GlobalValues.lat,GlobalValues.lng);
        truckadapter=new TruckAdapter();
        setListAdapter(truckadapter);
    }
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
	protected void onListItemClick(ListView l, View v, int position, long id)
	  {
		Bundle b=new Bundle();
		b.putString("truckname", rettv.get(position).name);
		Intent in=new Intent(this,TruckInfo.class);
		in.putExtras(b);
		startActivity(in);
	  }
	public void onClick(View arg0) 
	{
		
		
	}
    public void searchButtonClicked(View v)
    {
    	search=searchview.getText().toString();
    	searchbuttonclicked=true;
    	rettv=td.getTruckDetails(search.toLowerCase(), 0,GlobalValues.lat,GlobalValues.lng);
    	if(rettv.size()==0)
   			Toast.makeText(this, "No results found", 5000).show();
    	truckadapter.notifyDataSetChanged();
    
    }
    public void maps(View v)
	{
		Bundle b=new Bundle();
		if(!searchbuttonclicked)
		{
		b.putInt("type", 2);
		b.putString("name",cuisine);
		}
		else
		{
			b.putInt("type", 0);
			b.putString("name", search);
		}
		Intent in=new Intent(this,Maps.class);
		in.putExtras(b);
		startActivity(in);
	
	}
    protected Dialog onCreateDialog(int id) 
    {
    	final CharSequence[] items = {"Mexican", "Indian", "American","Japanese","Korean","Filipino","Filipino","Brazillian","Taiwanese"};

    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Pick a color");
    	builder.setItems(items, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) 
    	    {
    	    cuisine=items[item].toString();
    	    rettv=td.getInstance().getTruckDetails(cuisine, 2,GlobalValues.lat,GlobalValues.lng);
    	    truckadapter.notifyDataSetChanged();
//    	    	Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
    	    }
    	});
    	AlertDialog alert = builder.create();
    	return alert;
    }
    
  
}