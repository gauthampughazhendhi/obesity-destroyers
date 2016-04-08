package corp.s.a.i.obesitydestroyers;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.TweetViewFetchAdapter;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;


public class obese extends display{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obese);
        Double d3;

        Intent t=this.getIntent();
        d3=t.getDoubleExtra("ob",0);
       DecimalFormat g=new DecimalFormat("#.##");
        String gg=g.format(d3);
        Intent l=this.getIntent();
        String name=l.getStringExtra("nme");


        TextView disp;
        disp=(TextView)findViewById(R.id.tt0);
        disp.setText("\n\nHi "+name+"\n\nYou are obese\n" +
                "\n" +
                ""+"Your BMI is"+"\n"+gg+"\n\nBe a obesity destroyer");

        final Intent nn = new Intent(this,menu.class) ;
        Button button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                startActivity(nn);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_obese, menu);
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




    public void onBackPressed() {
        Intent myIntent = new Intent(this,bmicalc.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
        startActivity(myIntent);
        finish();
        return;
    }


}
