package cs588.ui.tructrac;

import java.sql.Date;

import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestPost extends Activity {

private CommonsHttpOAuthConsumer httpOauthConsumer;
private OAuthProvider httpOauthprovider;
public final static String consumerKey = "3B0Cg3sf5C50GQQ6IyDeQQ";
public final static String consumerSecret = "4R6ZVjeE3T1B69ZsbrbBhn42KVGek0KRZm6yjDlRrY";
private final String CALLBACKURL = "";
private Twitter twitter;
private TextView tweetTextView;
private Button buttonLogin;

// static Twitter jtwit;

/*
* 
* OnCreate method for class
*/

@Override

public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
tweetTextView = (TextView)findViewById(R.id.tweet);
buttonLogin = (Button)findViewById(R.id.ButtonLogin);

setContentView(R.layout.main2);
doOauth();
}
/**
* Opens the browser using signpost jar with application specific 
* consumerkey and consumerSecret.
*/

private void doOauth() {
try {
httpOauthConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
httpOauthprovider = new DefaultOAuthProvider("http://twitter.com/oauth/request_token",
"http://twitter.com/oauth/access_token",
"http://twitter.com/oauth/authorize");
String authUrl = httpOauthprovider.retrieveRequestToken(httpOauthConsumer, "oob");

this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)));
}
catch (Exception e) 
{
Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
}
}
/**
* After use authorizes this is the function where we get back callbac with
* user specific token and secret token. You might want to store this token
* for future use. 
*/




@Override

protected void onNewIntent(Intent intent) {

super.onNewIntent(intent);

Uri uri = intent.getData();
if (uri != null && uri.toString().startsWith(CALLBACKURL)) {

String verifier = uri.getQueryParameter(oauth.signpost.OAuth.OAUTH_VERIFIER);

try {
// this will populate token and token_secret in consumer

httpOauthprovider.retrieveAccessToken(httpOauthConsumer, verifier);

// TODO: you might want to store token and token_secret in you app settings!!!!!!!!

twitter4j.auth.AccessToken a =new twitter4j.auth.AccessToken(httpOauthConsumer.getToken(), httpOauthConsumer.getTokenSecret());

// initialize Twitter4J

twitter = new TwitterFactory().getInstance();
twitter.setOAuthConsumer(consumerKey, consumerSecret);
twitter.setOAuthAccessToken(a);

// create a tweet

Date d =new Date(System.currentTimeMillis());
String tweet = "#OAuth working! " + d.toLocaleString();

// send the tweet

twitter.updateStatus(tweet);

// feedback for the user...

tweetTextView.setText(tweet);
Toast.makeText(this, tweet, Toast.LENGTH_LONG).show();
buttonLogin.setVisibility(Button.GONE);

} catch (Exception e) {

Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
}

}
}


private void askOAuth() {
try {
httpOauthConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
httpOauthprovider = new DefaultOAuthProvider("http://twitter.com/oauth/request_token",
"http://twitter.com/oauth/access_token",
"http://twitter.com/oauth/authorize");
String authUrl = httpOauthprovider.retrieveRequestToken(httpOauthConsumer, CALLBACKURL);
Toast.makeText(this, "Please authorize this app!", Toast.LENGTH_LONG).show();
this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)));
} catch (Exception e) {

Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
}
}

}
