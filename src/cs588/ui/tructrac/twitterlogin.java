package cs588.ui.tructrac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class twitterlogin extends Activity{
	 @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.twitterlogin);
	    }
	public void login(View v)
	{
		Intent in=new Intent(this,options.class);
		startActivity(in);
	}

}
