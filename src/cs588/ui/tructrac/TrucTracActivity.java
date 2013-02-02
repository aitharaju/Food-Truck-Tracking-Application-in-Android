package cs588.ui.tructrac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TrucTracActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void login(View view)
    {
    Intent in=new Intent(this,twitterlogin.class);
    startActivity(in);
    }
}