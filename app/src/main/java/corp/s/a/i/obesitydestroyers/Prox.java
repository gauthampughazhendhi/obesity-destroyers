package corp.s.a.i.obesitydestroyers;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Prox extends Activity implements SensorEventListener {
    private SensorManager mSenMan;
    private Sensor mSen;
    TextView counter, target;
    int p;
    int n = 20;
    public static String file="shareddata";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prox_main);

        mSenMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSen = mSenMan.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        counter = (TextView) findViewById(R.id.tvproximity);
        target = (TextView) findViewById(R.id.tvtarget);
        target.setText("Target : 20");
        Button btn = (Button) findViewById(R.id.access);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initiatePopupwindow();
                //TextView tt=(TextView)findViewById(R.id.pop);
                //tt.setText("   Instructions:\n\n1.Place your phone  under your forehead .\n\n2.Every mobile has a proximity sensor which is somewhere near the front camera depending upon the handset.\n\n3.The proximity sensor must be exactly below your forehead\n\n4.Now start your push up and note that for each count your fore head should be at least at a height of three cm from the proximity sensor for each count.\n\n5.If the forehead is not at the prescribed height the count will not be incremented.This is to ensure maximum workout to burn your calories. ");

            }
        });
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        mSenMan.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        mSenMan.registerListener(this, mSen, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // TODO Auto-generated method stub
        if (event.values[0] == 0)
            p++;
        String s = Integer.toString(p);
        counter.setText(s);
        if (p >= n)
            target.setText("TARGET reached");
        sp =getSharedPreferences(file, 0);
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt("push",p);
        editor.commit();
    }

    private PopupWindow wind;

    private void initiatePopupwindow() {

            LayoutInflater inflater = (LayoutInflater) Prox.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup, (ViewGroup) findViewById(R.id.popu));
            wind = new PopupWindow(layout, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT, true);


        TextView tt=(TextView)layout.findViewById(R.id.pop);
        tt.setText("                                Instructions:\n\n1.Place your phone under your forehead.\n\n2.Every mobile has a proximity sensor which is somewhere near the front camera depending upon the handset.\n\n3.The proximity sensor must be exactly below your forehead.\n\n4.Now start your push up and note that for each count your fore head should be at least at a height of three cm from the proximity sensor.\n\n5.If the forehead is not at the prescribed height the count will not be incremented.This is to ensure maximum workout to burn your calories.\n\n                         Scroll down to exit. ");
        //tt.setText("gautham");
        wind.showAtLocation(layout, Gravity.CENTER, 0, 0);
        Button bt = (Button) layout.findViewById(R.id.pou);
            bt.setOnClickListener(cancel);
       /* } catch (Exception e) {
            e.printStackTrace();

        }*/


    }

    private View.OnClickListener cancel = new View.OnClickListener() {
        public void onClick(View v) {
            wind.dismiss();
        }
    };
}



