package cs588.ui.tructrac;

import java.util.List;

import cs588.ui.tructracobjects.Review;
import cs588.ui.tructracobjects.Truck;
import cs588.ui.tructracobjects.TruckList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class WriteReview extends Activity {
	public String truckname;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writereview);
        Bundle b=this.getIntent().getExtras();
        truckname=b.getString("name");
        
        
    }
 public void submit(View v)
 {
	 RatingBar rb=(RatingBar)findViewById(R.id.ratingbar);
	 EditText et=(EditText)findViewById(R.id.review);
	 String currentuser="Nikhil";
	 int ratingbar=(int)rb.getRating();
	 String review=et.getText().toString();
	 Review r=new Review(ratingbar,review,currentuser);
	 addReview(truckname,r);
	 Toast.makeText(this, "Review Submitted Successfully", 10000).show();
	 finish();
	 
 }
 public void addReview(String truckname,Review r)
 {
	 for(int i=0;i<TruckList.getInstance().trucklist.size();i++)
	 {
		 if(TruckList.getInstance().trucklist.get(i).name.equalsIgnoreCase(truckname))
		 {
			 TruckList.getInstance().trucklist.get(i).reviews.add(r);
			 System.out.println(TruckList.getInstance().trucklist.get(i).reviews.size());
		 }
	 }
 }
}