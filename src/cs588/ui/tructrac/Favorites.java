package cs588.ui.tructrac;


import java.lang.reflect.Field;
import java.util.List;

import cs588.ui.tructracobjects.GlobalValues;
import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
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

public class Favorites extends ListActivity implements OnClickListener{
    /** Called when the activity is first created. */
	private TruckAdapter truckadapter;
	TruckList td;
	List<Truck> rettv;
	String trucknames;
	
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
	public void onResume()
	{
		super.onResume();
		truckadapter.notifyDataSetChanged();
	}
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);
        truckadapter=new TruckAdapter();
        setListAdapter(truckadapter);
        
    }
	private class TruckAdapter extends BaseAdapter   
	{

		public int getCount() 
		{
			return GlobalValues.favorites.size();
			
		}

		public Truck getItem(int position) 
		{
			
			return GlobalValues.favorites.get(position);
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
			
			trucknames=GlobalValues.favorites.get(position).name;
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
			vh.nametv.setText(GlobalValues.favorites.get(position).name);
			vh.street.setText(GlobalValues.favorites.get(position).street);
			vh.rb.setRating(GlobalValues.favorites.get(position).rating);
			vh.city.setText(GlobalValues.favorites.get(position).city);
			vh.distance.setText(GlobalValues.favorites.get(position).miles+"miles");
			if(GlobalValues.favorites.get(position).status)
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
		b.putString("truckname", GlobalValues.favorites.get(position).name);
		Intent in=new Intent(this,TruckInfo.class);
		in.putExtras(b);
		startActivity(in);
	  }
	public void onClick(View arg0) 
	{
		
		
	}
    
  
}