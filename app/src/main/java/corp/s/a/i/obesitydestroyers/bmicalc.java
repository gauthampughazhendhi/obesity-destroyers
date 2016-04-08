package corp.s.a.i.obesitydestroyers;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;


public class bmicalc extends MainActivity {
    //start
    public static String file="shareddata";
    SharedPreferences sp;
//end

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);
        //public void display(View view) {
            final Intent it = new Intent(this, display.class);
            final EditText height = (EditText) findViewById(R.id.editText);
            final EditText weight = (EditText) findViewById(R.id.editText2);
            final EditText name = (EditText) findViewById(R.id.name);
        final EditText inches = (EditText) findViewById(R.id.editText4);
            final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(weight, InputMethodManager.SHOW_IMPLICIT);
final TextView tv=(TextView)findViewById(R.id.tv3);

        Typeface t=Typeface.createFromAsset(getAssets(),"helvetica1.ttf");
        TextView tt=(TextView)findViewById(R.id.textView4);
        tt.setTypeface(t);


        TextView tt3=(TextView)findViewById(R.id.tv3);
        tt3.setTypeface(t);


       final TextView ttt=(TextView)findViewById(R.id.textView5);
        ttt.setTypeface(t);


        TextView tt7=(TextView)findViewById(R.id.textView7);
        tt7.setTypeface(t);

            imm.showSoftInput(height, InputMethodManager.SHOW_IMPLICIT);
            imm.hideSoftInputFromWindow(height.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(weight.getWindowToken(), 0);
            // String name1;

            Button btn = (Button) findViewById(R.id.button2);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if (inches.getText().length() == 0 ||height.getText().length() == 0 ||name.getText().length()==0 || weight.getText().length() == 0 || (height.getText().length() == 0 && weight.getText().length() ==0 )) {
                        Double bmi;
                        bmi=2.0;
                        it.putExtra("bmi_val", bmi);
                        CharSequence text = "Enter the missing values";
                        int duration = Toast.LENGTH_LONG;
                        final Toast tost = Toast.makeText(bmicalc.this, text, duration);

                        tost.show();
                    } else {
                        Double s1 = 0.0;
                        s1 = Double.parseDouble(height.getText().toString());
                        Double s2 = 0.0;
                        s2 = Double.parseDouble(weight.getText().toString());
                        Double s3=0.0;
                        s3 = Double.parseDouble(inches.getText().toString());
                        s3=s3*0.083;
                        s1=s1+s3;


                       Double bmi;
                        s1=s1*0.304;
                        bmi =s2 / (s1 * s1);
                        String name1;
                    name1= name.getText().toString();
//start
                        sp =getSharedPreferences(file, 0);
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("namedata", name1);
                        editor.putString("weight",String.valueOf(s2));
                        //editor.putInt("bmidata",()bmi);
                        editor.commit();

//end


                        it.putExtra("bmi_val", bmi);
                        it.putExtra("name",name1);
                        it.putExtra("s1",s1);
                        startActivity(it);
                    }


                }
            });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmicalc, menu);
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
    /*public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", false);
        startActivity(intent);
        bmicalc.this.finish();
    }*/

}

   /* public void display(View view) {
        final Intent it = new Intent(this, display.class);
        final EditText height = (EditText) findViewById(R.id.editText);
        final EditText weight = (EditText) findViewById(R.id.editText2);
        final EditText name = (EditText) findViewById(R.id.name);
        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(weight, InputMethodManager.SHOW_IMPLICIT);


        imm.showSoftInput(height, InputMethodManager.SHOW_IMPLICIT);
        imm.hideSoftInputFromWindow(height.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(weight.getWindowToken(), 0);




        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Double s1 = 0.0;
                s1 = Double.parseDouble(height.getText().toString());
                Double s2 = 0.0;
                s2 = Double.parseDouble(weight.getText().toString());
                if (height.getText().length() == 0 || weight.getText().length() == 0 || (height.getText().length() == 0 && weight.getText().length() == 0)) {

                    CharSequence text = "Enter the missing values";
                    int duration = Toast.LENGTH_LONG;
                    final Toast tost = Toast.makeText(bmicalc.this, text, duration);

                    tost.show();
                } else {
                    Double bmi;
                    bmi = s2 / (s1 * s1);
                    it.putExtra("bmi_val", bmi);
                    startActivity(it);
                }


            }
        });
    }*/


