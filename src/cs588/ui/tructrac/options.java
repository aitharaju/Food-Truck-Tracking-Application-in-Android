package cs588.ui.tructrac;

import cs588.ui.tructracobjects.TruckList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

public class options extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        LocationManager locManager = (LocationManager) getSystemService(LOCATION_SERVICE);
try
{
        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
             createGpsDisabledAlert();
        }
}
catch(Exception e)
{
	e.printStackTrace();
}
    }
    public void location(View view)
    {
    	Intent in=new Intent(this,locs.class);
    	startActivity(in);
    }
    public void favorites(View view)
    {
    	Intent in=new Intent(this,Favorites.class);
    	startActivity(in);
    }
    public void augmented(View view)
    {
    	Intent in=new Intent(this,Augmented.class);
    	startActivity(in);
    }
    public void namesearch(View view)
    {
    	Intent in=new Intent(this,NameSearch.class);
    	startActivity(in);
    }
    public void cuisine(View view)
    {
    	Intent in=new Intent(this,Cusines.class);
    	startActivity(in);
    }
    private void createGpsDisabledAlert(){
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage("Your GPS is disabled! Would you like to enable it?")
    	     .setCancelable(false).setPositiveButton("Enable GPS",
    	          new DialogInterface.OnClickListener(){
    	          public void onClick(DialogInterface dialog, int id){
    	               showGpsOptions();
    	          }
    	     });
    	     builder.setNegativeButton("Do nothing",
    	          new DialogInterface.OnClickListener(){
    	          public void onClick(DialogInterface dialog, int id){
    	               dialog.cancel();
    	          }
    	     });
    	AlertDialog alert = builder.create();
    	alert.show();
    	}

    	private void showGpsOptions(){
    			Intent gpsOptionsIntent = new Intent(
    					android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    			startActivity(gpsOptionsIntent);
    	}

 
}