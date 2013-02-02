package cs588.ui.tructrac;


import java.util.List;

import cs588.ui.tructracobjects.GlobalValues;
import cs588.ui.tructracobjects.Menus;
import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;
import cs588.ui.tructracobjects.Tweets;



import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Tweet extends ListActivity implements OnClickListener{
    /** Called when the activity is first created. */
	private TruckAdapter truckadapter;
	TruckList td;
	List<Truck> rettv;
	List<Tweets> tweets;
	private static class ViewHolder
	{
		TextView item;
		TextView price;
		
		
		
	}
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter);
        Bundle b;
        b=this.getIntent().getExtras();
        String name=b.getString("truckname");
        tweets=GlobalValues.getInstance().hm.get(name+"twitter");
        td=new TruckList();
        rettv=td.getTruckDetails("calibi", 0,GlobalValues.lat,GlobalValues.lng);
        truckadapter=new TruckAdapter();
        setListAdapter(truckadapter);
        
    }
	private class TruckAdapter extends BaseAdapter   
	{

		public int getCount() 
		{
			return tweets.size();
			// TODO Auto-generated method stub
			//return rettv.size();
		}

		public Tweets getItem(int position) {
			// TODO Auto-generated method stub
			return tweets.get(position);
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
	             v = vi.inflate(R.layout.rowinlist4, null);  
	             vh.item=(TextView)v.findViewById(R.id.tweets);
	             vh.price=(TextView)v.findViewById(R.id.date);
	             v.setTag(vh);
				
			}
			else
			{
				vh=(ViewHolder) v.getTag();
			}
			vh.item.setText(tweets.get(arg0).tweet);
			vh.price.setText(tweets.get(arg0).dates);
			
			
			return v;
			
			
			
		}
		
	}
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
    
  
}