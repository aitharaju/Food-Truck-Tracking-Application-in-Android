package cs588.ui.tructrac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Reviews extends Activity { 
	RatingBar rb;
	TextView review,reviewer;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);
    	Bundle b;
    	b=this.getIntent().getExtras();
    	reviewer=(TextView)findViewById(R.id.reviewer);
    	review=(TextView)findViewById(R.id.reviews);
    	rb=(RatingBar)findViewById(R.id.ratingbar);
//    	System.out.println(b.getFloat("rating"));
    	rb.setRating(b.getFloat("rating"));
    	review.setText(b.getString("review"));
     	reviewer.setText(b.getString("reviewer"));
       
    }
    public void location(View view)
    {
    	Intent in=new Intent(this,locs.class);
    	startActivity(in);
    }
}