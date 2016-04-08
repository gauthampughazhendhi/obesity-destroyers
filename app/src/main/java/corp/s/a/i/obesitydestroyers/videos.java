package corp.s.a.i.obesitydestroyers;

import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import corp.s.a.i.obesitydestroyers.R;
import corp.s.a.i.obesitydestroyers.Task;
import corp.s.a.i.obesitydestroyers.Video;

public class videos extends Activity {
    ImageView img,ticked;
    ImageButton next,prev;
    TextView sno;
    int i,novid=26;




    String sb[]={"viewed1","viewed2","viewed3","viewed4","viewed5","viewed6","viewed7","viewed8","viewed9","viewed10","viewed11","viewed12","viewed13","viewed14","viewed15","viewed16","viewed17","viewed18","viewed19","viewed20","viewed21","viewed22","viewed23","viewed24","viewed25","viewed26","viewed27","viewed28"};
    boolean viewed[]={false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    String arr[]={"AFBGC2RE8K4","x9RD0ryWmTY"
            ,"hpLPP8HXyjs"
            ,"yCrS8Q5tJ-o"
            ,"6ZcFuhM0tpw"
            ,"G4rY67BZ_Mc"
            ,"6fflrr2RA88"
            ,"8YNWm18hOyg"
            ,"ce3dC2iQOI8"
            ,"Tr9aCIxW5_c"
            ,"S9nMxvdAdQY"
            ,"0aNrurfk2jU"
            ,"CTZIGHg-9MA"
            ,"s8wQAp0ItxM"
            ,"rvCSyaA8Rio" ,"6fsQPM9xek8", "PL9m8spuMQ4"," Ls64XxsV_YI"," SAUY5vCpfUk", "QqdpKeb7aIs", "sOr1ado8QeI", "yf1MtRZx_J4", "XtCRQ9E8sTQ", "AkgqchMqosw","I8Ct_ZMRsIQ"

    };


    public static String file="shareddata";
    SharedPreferences sp;

    RelativeLayout Rl;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos);
       // Rl=(RelativeLayout) findViewById(R.layout.activity_main);
        img=(ImageView) findViewById(R.id.img1);
        ticked=(ImageView) findViewById(R.id.iview);
        next=(ImageButton) findViewById(R.id.bnext);
        prev=(ImageButton) findViewById(R.id.bprev);
        sno=(TextView)findViewById(R.id.tv1);


        i=geti();
        img.setImageResource(img(i));
        findavg();
        //	String s=Float.toString(findavg());
        //avg.setText(s+"%");
        //	Rl.setBackgroundColor(Color.GREEN) ;
        sno.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                Intent test=new Intent(videos.this,Task.class);
                startActivity(test);
            }
        });
        img.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //	img.setImageResource(R.drawable.i3);
                //	sno.setText(sb[i]);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean(sb[i], true);
                editor.commit();
                Intent myIntent = new Intent(videos.this, Video.class);
                myIntent.putExtra("text", arr[i - 1]);




                startActivity(myIntent);
                //   Intent intent = YouTubeStandalonePlayer.createVideoIntent(this, "<<YOUTUBE_API_KEY>>", "<<Youtube Video ID>>", 0, true, false);
                // startActivity(intent);
            }
        });
        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                //	 SharedPreferences.Editor editor=sp.edit();
                //	editor.putBoolean(sb[i],false);
                //	editor.commit();

                if (i < novid)
                    i++;
                img.setImageResource(img(i));


                //getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                //Intent proxi=new Intent(MainActivity.this,Prox.class);
                //startActivity(proxi);
            }
        });
        prev.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(i>1)
                    i--;
                img.setImageResource(img(i));
            }
        });
    }




    int findavg()
    {   int i,a=0;
        boolean b;
        sp =getSharedPreferences(file, 0);
        for(i=1;i<=novid;i++)
        {
            b = sp.getBoolean(sb[i],false);
            if(b==true)
                a++;
        }

        SharedPreferences.Editor editor=sp.edit();
        editor.putInt("exer",a);
        editor.commit();

        //sno.setText(Integer.toString(a));
        return a;

    }
    int img(int i) {
        // TODO Auto-generated method stub
        boolean b;
        findavg();
        //avg.setText(s+"%");
        sp =getSharedPreferences(file, 0);
        b = sp.getBoolean(sb[i],false);
        viewed[i]=b;
        String s1=Integer.toString(i);
        if(b==true)
            ticked.setVisibility(View.VISIBLE);
        else
            ticked.setVisibility(View.GONE);
        Typeface t=Typeface.createFromAsset(getAssets(),"helvetica1.ttf");
        sno.setTypeface(t);
        sno.setText("Class "+s1);
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt("idata", i);
        editor.commit();
        switch(i)
        {
            case 1:return R.mipmap.i1;
            case 2:return R.mipmap.i2;
            case 3:return R.mipmap.i3;
            case 4:return R.mipmap.i4;
            case 5:return R.mipmap.i5;
            case 6:return R.mipmap.i6;
            case 7:return R.mipmap.i7;
            case 8:return R.mipmap.i8;
            case 9:return R.mipmap.i9;
            case 10:return R.mipmap.i10;
            case 11:return R.mipmap.i11;
            case 12:return R.mipmap.i12;
            case 13:return R.mipmap.i13;
            case 14:return R.mipmap.i14;
            case 15:return R.mipmap.i15;
            case 16:return R.mipmap.i16;
            case 17:return R.mipmap.i17;
            case 18:return R.mipmap.i18;
            case 19:return R.mipmap.i19;
            case 20:return R.mipmap.i20;
            case 21:return R.mipmap.i21;
            case 22:return R.mipmap.i22;
            case 23:return R.mipmap.i23;
            case 24:return R.mipmap.i24;
            case 25:return R.mipmap.i25;
            case 26:sno.setText("More classes are\n\n coming soon!!"); return R.drawable.w1;
        }
        return R.drawable.w1;
    }
    int geti()
    {
        sp =getSharedPreferences(file, 0);
        i = sp.getInt("idata", 1);
        return i;
    }

    }

