package cs588.ui.tructrac;


import java.lang.reflect.Field;
import java.util.List;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


import cs588.ui.tructrac.R.drawable;
import cs588.ui.tructracobjects.GlobalValues;
import cs588.ui.tructracobjects.Review;
import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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

public class TruckInfo extends ListActivity implements OnClickListener{
    /** Called when the activity is first created. */
	private TruckAdapter truckadapter;
	TruckList td;
	List<Truck> rettv;
	ImageView iv;
	TextView nametv;
	RatingBar rb;
	TextView street;
	TextView city;
	TextView distance;
	ImageView status;
	List<Review> reviews;
	String nametemp;
	String truckname;
	Context context;
	String checkinmessage;
	double lat,lng;
	private static class ViewHolder
	{
		TextView review;
		TextView reviewer;
		RatingBar rating;
	}
	@Override
	public void onResume()
	{
		super.onResume();
		reviews=td.getTruckDetails(truckname, 0,GlobalValues.lat,GlobalValues.lng).get(0).reviews;
		truckadapter.notifyDataSetChanged();
	
	}
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.truckinfo);
        td=TruckList.getInstance();
        context=this;
        Bundle bundle=this.getIntent().getExtras();
        truckname=bundle.getString("truckname");
        rettv=td.getTruckDetails(truckname, 0,GlobalValues.lat,GlobalValues.lng);
        if(rettv.size()!=0)
        {
        iv=(ImageView)findViewById(R.id.truckimage);
        street=(TextView)findViewById(R.id.street);
        city=(TextView)findViewById(R.id.city);
        rb=(RatingBar)findViewById(R.id.ratingbar);
        nametv=(TextView)findViewById(R.id.name);
        distance=(TextView)findViewById(R.id.distance);
        status=(ImageView)findViewById(R.id.status);
        TextView tv=(TextView)findViewById(R.id.fav);
		if(TruckList.getInstance().getTruckDetails(truckname,0,GlobalValues.lat,GlobalValues.lng).get(0).fav)
		{
			tv.setCompoundDrawablesWithIntrinsicBounds  (0, drawable.fav, 0, 0);
		}
		else
		{			
			tv.setCompoundDrawablesWithIntrinsicBounds  (0, drawable.favoff, 0, 0);

			
		}
       
		try 
		{
			int drawableId;
		    Class res = R.drawable.class;
		    Field field = res.getField(truckname);
		    drawableId = field.getInt(null);
			iv.setImageResource(drawableId);

		}
		catch (Exception e) 
		{
		    Log.e("MyTag", "Failure to get drawable id.", e);
		}
//		System.out.println(rettv.get(position).name);
		nametemp=rettv.get(0).name;
		nametv.setText(nametemp);
		street.setText(rettv.get(0).street);
		rb.setRating(rettv.get(0).rating);
		city.setText(rettv.get(0).city);
		lat=rettv.get(0).lat;
		lng=rettv.get(0).lng;
		distance.setText(rettv.get(0).miles+"miles");
		checkinmessage="At "+nametemp+" "+rettv.get(0).street+" "+rettv.get(0).city;
		if(rettv.get(0).status)
		{
			status.setImageResource(R.drawable.greendot);	
		}
		else
			status.setImageResource(R.drawable.rd);
		GlobalValues.getInstance().hm.put(nametemp+"menu", rettv.get(0).menu);
		GlobalValues.getInstance().hm.put(nametemp+"twitter", rettv.get(0).tweets);
		reviews=rettv.get(0).reviews;
        truckadapter=new TruckAdapter();
        setListAdapter(truckadapter);
        }
        
    }
    
	private class TruckAdapter extends BaseAdapter   
	{

		public int getCount() 
		{
			return reviews.size();
			// TODO Auto-generated method stub
			//return rettv.size();
		}

		public Review getItem(int position) {
			// TODO Auto-generated method stub
			return reviews.get(position);
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int arg0, View arg1, ViewGroup arg2) 
		{
			View v=arg1;
			ViewHolder vh;
			if(v==null)
			{
				 vh=new ViewHolder();
	             LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	             v = vi.inflate(R.layout.rowinlist22, null);  
	             vh.rating=(RatingBar)v.findViewById(R.id.ratingbar);
	             vh.review=(TextView)v.findViewById(R.id.review);
	             vh.reviewer=(TextView)v.findViewById(R.id.reviewer);
	             v.setTag(vh);
			}
			else
			{
				vh=(ViewHolder)arg1.getTag();
				
			}
			vh.rating.setRating(reviews.get(arg0).rating);
			vh.review.setText(reviews.get(arg0).review);
			vh.reviewer.setText(reviews.get(arg0).reviewer);
			return v;
			
			
			
		}
		  
		
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id)
	  {
		Bundle b=new Bundle();
		b.putFloat("rating",reviews.get(position).rating);
		b.putString("review", reviews.get(position).review);
		b.putString("reviewer", reviews.get(position).reviewer);
		Intent in=new Intent(this,Reviews.class);
		in.putExtras(b);
		startActivity(in);
	  }
	public void toggle(View v)
	{
		TextView tv=(TextView)findViewById(R.id.fav);
		Truck v1=TruckList.getInstance().getTruckDetails(truckname,0,GlobalValues.lat,GlobalValues.lng).get(0);
		if(v1.fav)
		{
			tv.setCompoundDrawablesWithIntrinsicBounds  (0, drawable.favoff, 0, 0);
			GlobalValues.getInstance().favorites.remove(v1);
			System.out.println(GlobalValues.getInstance().favorites.size()+"size");
			TruckList.getInstance().getTruckDetails(truckname,0,GlobalValues.lat,GlobalValues.lng).get(0).fav=false;
		}
		else
		{
			tv.setCompoundDrawablesWithIntrinsicBounds  (0, drawable.fav, 0, 0);
			GlobalValues.getInstance().favorites.add(v1);
			System.out.println(GlobalValues.getInstance().favorites.size()+"sizes");

			TruckList.getInstance().getTruckDetails(truckname,0,GlobalValues.lat,GlobalValues.lng).get(0).fav=true;


		}
	}
	public void onClick(View arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	public void writereview(View v)
	{
		Bundle b=new Bundle();
		b.putString("name",nametemp);
		
		Intent in=new Intent(this,WriteReview.class);
		in.putExtras(b);
		startActivity(in);
	}
	
	public void tweets(View v)
	{
		Bundle b=new Bundle();
		b.putString("truckname", nametemp);
		Intent in=new Intent(this,Tweet.class);
		in.putExtras(b);
		startActivity(in);
	}
	public void direction(View v)
	{
		String uri = "geo:"+ 0 + "," + 0+"?q="+rettv.get(0).street+" "+rettv.get(0).city;
        startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
	}
	public void checkin(View view)
	{
		showDialog(0);
	}
	public void menuButton(View view)
    {
//		Twitter twitter = new TwitterFactory().getInstance();
//		AccessToken a = new AccessToken("127274227-b77OaV9AITfMGZFDhsIiFBTKeTDLpsSpJt7KeB4", "pQGOLhwl4QKKCgfWq987hLs0T9pbQtl2jhMq144a4");
//		twitter.setOAuthConsumer("3B0Cg3sf5C50GQQ6IyDeQQ","4R6ZVjeE3T1B69ZsbrbBhn42KVGek0KRZm6yjDlRrY");
//		twitter.setOAuthAccessToken(a); 
//		try {
//			twitter.updateStatus("If you're reading this on Twitter, it worked!");
//		} catch (TwitterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		 	Bundle b=new Bundle();
		 	b.putString("truckname",nametemp);
	    	Intent in=new Intent(this,Menu.class);
	    	in.putExtras(b);
	    	startActivity(in);
	    }
	 private class SelectDataTask extends AsyncTask<Void, Void, String> {
   	  private final ProgressDialog dialog = new ProgressDialog(context);   
       // can use UI thread here
       protected void onPreExecute() 
       {
       	try
       	{
       	 dialog.setMessage("Loading....");
         dialog.show();
       	}
       	catch(Exception e)
       	{
       	e.printStackTrace();        	
       	}
            }
  
       // automatically done on worker thread (separate from UI thread)
       protected String doInBackground(Void ...params) {
       String error;
    		Twitter twitter = new TwitterFactory().getInstance();
 		AccessToken a = new AccessToken("127274227-b77OaV9AITfMGZFDhsIiFBTKeTDLpsSpJt7KeB4", "pQGOLhwl4QKKCgfWq987hLs0T9pbQtl2jhMq144a4");
    		twitter.setOAuthConsumer("3B0Cg3sf5C50GQQ6IyDeQQ","4R6ZVjeE3T1B69ZsbrbBhn42KVGek0KRZm6yjDlRrY");
    		twitter.setOAuthAccessToken(a); 
    		try {
    			twitter.updateStatus(checkinmessage);
    			error="Check In Successful";
    		} catch (TwitterException e) {
    			// TODO Auto-generated catch block
error="Check In Failed";    		}
		 
          return error;
       }
  
       // can use UI thread here
       protected void onPostExecute(final String result) {
            dialog.cancel();
            Toast.makeText(context, result, 5000).show();
         
          


       }
    }
  
	 protected Dialog onCreateDialog(int id) 
	 {
		 AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 builder.setMessage("Are you sure you want to Check In?")
		        .setCancelable(false)
		        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		            	SelectDataTask a=new SelectDataTask();
		        		a.execute();
		            }
		        })
		        .setNegativeButton("No", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		                 dialog.cancel();
		            }
		        });
		 AlertDialog alert = builder.create();
		return alert; 
	 }
}