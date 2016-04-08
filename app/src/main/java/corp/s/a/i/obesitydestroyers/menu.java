package corp.s.a.i.obesitydestroyers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import corp.s.a.i.obesitydestroyers.R;
import corp.s.a.i.obesitydestroyers.obese;

public class menu extends obese {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final Intent in=new Intent(this,tweet.class);
        Button bt=(Button)findViewById(R.id.button9);
        Button ins=(Button)findViewById(R.id.ins);

        Button videos=(Button)findViewById(R.id.button5);
        Button push=(Button)findViewById(R.id.button6);
        Button task=(Button)findViewById(R.id.button7);
        Button th=(Button)findViewById(R.id.button4);
        Button b8=(Button)findViewById(R.id.button8);
        Toast.makeText(getBaseContext(),"Press back to go to BMI calculator",Toast.LENGTH_SHORT).show();
        if(getIntent().getBooleanExtra("EXIT",false))
        {
            finish();
        }
//second activity
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(menu.this,show.class);
                startActivity(in);
            }
            });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp =getSharedPreferences("shareddat", 0);
                int n= sp.getInt("j", 0);
                if(n==0) {
                    Intent i = new Intent(menu.this, Jmeter.class);
                    sp =getSharedPreferences("shareddat", 0);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putInt("j", 1);
                    editor.commit();
                    startActivity(i);
                    menu.this.finish();
                }
                else{
                    Toast.makeText(getBaseContext(), "gps signals  not available consider restarting the app", Toast.LENGTH_LONG).show();
                            Intent i=new Intent(menu.this,error.class);
                    startActivity(i);
                }
            }
        });


        th.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent i=new Intent(menu.this,Theorylist.class);

                startActivity(i);
            }
        });


        bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                startActivity(in);
            }
        });
        if(getIntent().getBooleanExtra("EXIT",false))
        {
            finish();
        }
        videos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu.this,videos.class);


                startActivity(i);
            }
        });
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu.this,Prox.class);

                startActivity(i);
            }
        });
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu.this,Task.class);

                startActivity(i);
            }
        });
        Typeface t=Typeface.createFromAsset(getAssets(),"helvetica1.ttf");
        TextView tt=(TextView)findViewById(R.id.textView9);
        tt.setTypeface(t);

        TextView tt10=(TextView)findViewById(R.id.textView10);
        tt10.setTypeface(t);
        TextView tt8=(TextView)findViewById(R.id.textView8);
        tt8.setTypeface(t);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
}
