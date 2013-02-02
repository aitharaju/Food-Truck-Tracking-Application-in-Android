package cs588.ui.tructrac;
import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import cs588.ui.tructrac.R;
import cs588.ui.tructracobjects.GlobalValues;
import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;




public class Maps extends MapActivity
{
int type;
String name;
TruckList td;
MyItemizedOverlay itemizedOverlay,itemizedOverlay2,itemizedOverlay3;
MapView mapView;
Drawable drawable,drawable2,drawable3;

List<Overlay> mapOverlays;
List<Truck> rettv;

	 @Override
	    public void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.maps);
	        mapView = (MapView) findViewById(R.id.mapView);
	        mapView.setBuiltInZoomControls(true);
			mapOverlays = mapView.getOverlays();
			// first overlay
			drawable = getResources().getDrawable(R.drawable.mypos);
			drawable2=getResources().getDrawable(R.drawable.greenmarker);
			drawable3=getResources().getDrawable(R.drawable.redmarker);

			itemizedOverlay = new MyItemizedOverlay(drawable, mapView);
			itemizedOverlay2 = new MyItemizedOverlay(drawable2, mapView);
			itemizedOverlay3 = new MyItemizedOverlay(drawable3, mapView);


			GeoPoint myloc = new GeoPoint((int)(GlobalValues.lat*1E6),(int)(GlobalValues.lng*1E6));
			OverlayItem overlayItem = new OverlayItem(myloc, "Nikhil", 
					"");
			itemizedOverlay.addOverlay(overlayItem);
			mapOverlays.add(itemizedOverlay);
			
	        
	        
	        
	        Bundle b=this.getIntent().getExtras();
	        type=b.getInt("type");
	        name=b.getString("name");
	        td=td.getInstance();
	        rettv=td.getInstance().getTruckDetails(name,type ,GlobalValues.lat,GlobalValues.lng);
	        for(int i=0;i<rettv.size();i++)
	        {
	        	
	        	GeoPoint point = new GeoPoint((int)((rettv.get(i).lat)*1E6),(int)((rettv.get(i).lng)*1E6));
				OverlayItem overlayItems = new OverlayItem(point, rettv.get(i).name, 
						rettv.get(i).street+" "+rettv.get(i).city);
				if(rettv.get(i).status)
				{
				itemizedOverlay2.addOverlay(overlayItems);
				mapOverlays.add(itemizedOverlay2);

				}
				else
				{
					itemizedOverlay3.addOverlay(overlayItems);
					mapOverlays.add(itemizedOverlay3);
				}
					
	        }

	        final MapController mc = mapView.getController();
			mc.animateTo(myloc);
			mc.setZoom(14);

	 }
	 public void searchButtonClicked(View v)
	    {
		 TextView searchView=(TextView)findViewById(R.id.searchbox)	;

		 String search=searchView.getText().toString();
		 mapView.getOverlays().clear();
	   	 mapView.postInvalidate();
	   	 mapOverlays.clear();
	   
	   	 updateView(search);
	    	
	    }
	 public void updateView(String search)
	 {
			itemizedOverlay = new MyItemizedOverlay(drawable, mapView);
			itemizedOverlay2 = new MyItemizedOverlay(drawable2, mapView);
			itemizedOverlay3 = new MyItemizedOverlay(drawable3, mapView);

		 GeoPoint myloc = new GeoPoint((int)(GlobalValues.lat*1E6),(int)(GlobalValues.lng*1E6));
			OverlayItem overlayItem = new OverlayItem(myloc, "Nikhil", 
					"");
			itemizedOverlay.addOverlay(overlayItem);
			mapOverlays.add(itemizedOverlay);
			rettv.clear();
			rettv=td.getTruckDetails(search.toLowerCase(),0 ,GlobalValues.lat,GlobalValues.lng);
	        for(int i=0;i<rettv.size();i++)
	        {
	        	System.out.println("Sds");
	        	
	        	GeoPoint point = new GeoPoint((int)((rettv.get(i).lat)*1E6),(int)((rettv.get(i).lng)*1E6));
				OverlayItem overlayItems = new OverlayItem(point, rettv.get(i).name, 
						rettv.get(i).street+" "+rettv.get(i).city);
				if(rettv.get(i).status)
				{
				itemizedOverlay2.addOverlay(overlayItems);
				mapOverlays.add(itemizedOverlay2);

				}
				else
				{
					itemizedOverlay3.addOverlay(overlayItems);
					mapOverlays.add(itemizedOverlay3);
				}
					
	        }

	        final MapController mc = mapView.getController();
			mc.animateTo(myloc);
			mc.setZoom(14);
	 }
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	 
}
