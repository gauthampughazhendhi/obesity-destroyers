package corp.s.a.i.obesitydestroyers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;


public class display extends bmicalc {
    //     boolean isA=false,isW=false;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.display);

        TextView show;
        show = (TextView) findViewById(R.id.textView6);
        btn = (Button) findViewById(R.id.btnmenu);
        Intent t = this.getIntent();
        Intent n = this.getIntent();
        int mode = t.getIntExtra("mode", 0);
        String g1 = t.getStringExtra("dist");
        String k = t.getStringExtra("cal");

        if (mode == 0) {
            btn.setVisibility(View.GONE);
            DecimalFormat df = new DecimalFormat("#.##");
            Double d1 = t.getDoubleExtra("bmi_val", 0);
            String name = n.getStringExtra("name");
            String g = df.format(d1);


            if (d1 >= 18.9 && d1 <= 24.5) {
                show.setText("\n Hi " + name + "\n\n\n Your BMI is \n" + g
                                + "\n\nYou are normal." +
                                " \n \n\n Maintain Your BMI." + "\n" +
                                "  \n \n\nMaintain your current diet."

                );
            } else if (d1 < 18.9) {
                show.setText("\nHi " + name + "\n\n\nYour BMI is\n " + g + "\n"
                                + "\n\n\n You are under weight   " + "\n" +
                                " \n\n\n Please increase your diet"

                );
            } else if (d1 > 24.5) {
                Intent in = new Intent(this, obese.class);
                in.putExtra("nme", name);
                in.putExtra("ob", d1);
                startActivity(in);

            }
        } else {

            if (g1 == null ){
                g1 = "0";
                k = "0";
            }
            show.setText(" \n \n\n You have run " + g1 + " Km. \n \n\n\n \n You have burnt " + k + " calories. ");



        }
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent i = new Intent(display.this, menu.class);

                startActivity(i);
                display.this.finish();
            }
        });
    }
//checkSDStuff();
/*if(isA&&isW)
{
  File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
    File file=new File(path,"data1.txt");

    try {
        path.mkdirs();
       // InputStream is ;//= getResources().openRawResource(R.drawable.exit);
        OutputStream os;
        os = new FileOutputStream(file);
     //   byte[] data = new byte[is.available()];
     //   is.read(data);
        os.write(name.getBytes());
      //  is.close();
        os.close();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
        else{
    int duration = Toast.LENGTH_LONG;
    final Toast tost = Toast.makeText(display.this, "error", duration);

    tost.show();
        }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
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
    public void onBackPressed(){
        Intent intent = new Intent(this,menu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", false);
        startActivity(intent);
        display.this.finish();
    }

}