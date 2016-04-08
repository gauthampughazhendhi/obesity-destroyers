package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;


public class MainActivity extends Activity{

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "tHYhL6zt6k3hKGzsmlyuEL0Go";
    private static final String TWITTER_SECRET = "6w71vChzQHOaAHmY59vSLik9bdYV8Xv3amJjd6wPGzrRX3ljm1";
    //start
    public static String file="shareddata";
    SharedPreferences sp,sp1;
    //end


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);
        //bmicalc();
        //public void bmicalc(View view) {
//start




        Typeface t=Typeface.createFromAsset(getAssets(),"helevetica.ttf");
        TextView tt=(TextView)findViewById(R.id.textView);
        tt.setTypeface(t);
        tt.setText("\n  Welcome to");
        TextView tl=(TextView)findViewById(R.id.textView15);
        tl.setTypeface(t);
        tl.setText("\nObesity\nDestroyers");
     //   tt.setGravity(12);

        final Intent n;
        sp =getSharedPreferences(file, 0);
        SharedPreferences.Editor editor=sp.edit();

        String name= sp.getString("namedata", "");




        //main activity
        sp1 =getSharedPreferences("shareddat", 0);
        SharedPreferences.Editor editor1=sp1.edit();
        editor1.putInt("j",0);
        editor1.commit();






        if(getIntent().getBooleanExtra("EXIT",false))
        {
            finish();
        }

        if(name.length()==0)
            n= new Intent(this,bmicalc.class);
        else
            n= new Intent(this, menu.class);
        //end



            Button button=(Button)findViewById(R.id.button);


            button.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {

                    Button button=(Button)findViewById(R.id.button);
                    button.requestFocus();
                    startActivity(n);
                    MainActivity.this.finish();
                }
            });//}

        /*Typeface face=Typeface.createFromAsset(getAssets(),getString(R.string.font));
        h.setTypeface(face);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


  /*  public void bmicalc(View view) {

        final Intent n;
        n= new Intent(this,bmicalc.class);

        Button button=(Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View view) {

            Button button=(Button)findViewById(R.id.button);
            button.requestFocus();

            startActivity(n);
        }
    });}*/
}
