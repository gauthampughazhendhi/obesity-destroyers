package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by shiva on 23/9/15.
 */
public class Untitled extends Activity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.untitled);
        b1=(Button)findViewById(R.id.btu1);
        b2=(Button)findViewById(R.id.btu2);
        b3=(Button)findViewById(R.id.btu3);
        b4=(Button)findViewById(R.id.btu4);
        b5=(Button)findViewById(R.id.btu5);
        b6=(Button)findViewById(R.id.btu6);
        b7=(Button)findViewById(R.id.btu7);
        b8=(Button)findViewById(R.id.btu8);
        b9=(Button)findViewById(R.id.btu9);
        b10=(Button)findViewById(R.id.btu10);
        b11=(Button)findViewById(R.id.btu11);
        b12=(Button)findViewById(R.id.btu12);
        b13=(Button)findViewById(R.id.btu13);
        b14=(Button)findViewById(R.id.btu14);
        b15=(Button)findViewById(R.id.btu15);
        final Intent I=new Intent(this,Untitled1.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b1.getText());
                I.putExtra("ind",0);
                startActivity(I);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b2.getText());
                I.putExtra("ind",1);
                startActivity(I);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b3.getText());
                I.putExtra("ind",2);
                startActivity(I);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b4.getText());
                I.putExtra("ind",3);
                startActivity(I);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b5.getText());
                I.putExtra("ind",4);
                startActivity(I);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b6.getText());
                I.putExtra("ind",5);
                startActivity(I);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b7.getText());
                I.putExtra("ind",6);
                startActivity(I);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b8.getText());
                I.putExtra("ind",7);
                startActivity(I);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b9.getText());
                I.putExtra("ind",8);
                startActivity(I);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b10.getText());
                I.putExtra("ind",9);
                startActivity(I);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b11.getText());
                I.putExtra("ind",10);
                startActivity(I);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b12.getText());
                I.putExtra("ind",11);
                startActivity(I);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b13.getText());
                I.putExtra("ind",12);
                startActivity(I);
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b14.getText());
                I.putExtra("ind",13);
                startActivity(I);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.putExtra("head",b15.getText());
                I.putExtra("ind",14);
                startActivity(I);
            }
        });

    }
}
