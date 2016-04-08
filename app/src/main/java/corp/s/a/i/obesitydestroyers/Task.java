package corp.s.a.i.obesitydestroyers;

import java.util.Calendar;
//import java.util.Date;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Task extends  Activity {
   
    TextView tvexe,tv;
    SharedPreferences sp;
    int i,p;
    ProgressBar pexe,pdiet,ppush;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task);
		pexe=(ProgressBar) findViewById(R.id.progressBar1);
		ppush=(ProgressBar)findViewById(R.id.progressBar2);
		tvexe=(TextView)findViewById(R.id.textView1);
		tvexe=(TextView)findViewById(R.id.textView2);
		sp=getSharedPreferences("shareddata", 0);
		i =sp.getInt("exer", 0);
		p =sp.getInt("push",0);
		if(p>20)
			p=20;
		pexe.setMax(25);
		pexe.setProgress(i);
		ppush.setMax(20);
		ppush.setProgress(p);
		float s=((float)i/25*100);
        tvexe.setText(Integer.toString((int) s) + "%");
		float k=((float)p/20*100);
		tvexe.setText(Integer.toString((int)k)+"%");

	}
}
