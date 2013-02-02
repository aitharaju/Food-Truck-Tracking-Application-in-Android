package cs588.ui.tructrac;


import java.util.List;

import cs588.ui.tructracobjects.GlobalValues;
import cs588.ui.tructracobjects.Menus;
import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;



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

public class Menu extends ListActivity implements OnClickListener{
    /** Called when the activity is first created. */
	private TruckAdapter truckadapter;
	TruckList td;
	List<Truck> rettv;
	List<Menus> menu;
	private static class ViewHolder
	{
		TextView item;
		TextView price;
		
		
		
	}
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Bundle b;
        b=this.getIntent().getExtras();
        String name=b.getString("truckname");
       
        menu=GlobalValues.getInstance().hm.get(name+"menu");
        td=new TruckList();
     //   rettv=td.getTruckDetails("calibibbq", 0,GlobalValues.lat,GlobalValues.lng);
        truckadapter=new TruckAdapter();
        setListAdapter(truckadapter);
        
    }
	private class TruckAdapter extends BaseAdapter   
	{

		public int getCount() 
		{
			return menu.size();
			// TODO Auto-generated method stub
			//return rettv.size();
		}

		public Menus getItem(int position) {
			// TODO Auto-generated method stub
			return menu.get(position);
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
	             v = vi.inflate(R.layout.rowinlist3, null);  
	             vh.item=(TextView)v.findViewById(R.id.item);
	             vh.price=(TextView)v.findViewById(R.id.price);
	             v.setTag(vh);
				
			}
			else
			{
				vh=(ViewHolder) v.getTag();
			}
			vh.item.setText(menu.get(arg0).menuitem);
			vh.price.setText(menu.get(arg0).price);
			
			
			return v;
			
			
			
		}
		
	}
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
    
  
}