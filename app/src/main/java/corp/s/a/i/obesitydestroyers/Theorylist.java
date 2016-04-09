package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Theorylist extends Activity  {
    String list[]={"What is Obesity?","What is Body Mass Index(BMI)?","Why do people become obese?","How to overcome obesity?","Foods to AVOID when treating obesity","Other dietary recommendations","Efforts to be taken","Other Tips for Treating Obesity","Therapies to be followed"};
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th);
        Button b0=(Button)findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b10 = (Button) findViewById(R.id.button10);
        b11 = (Button) findViewById(R.id.button11);
       final Intent I = new Intent(this, Theory.class);
        b0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               I.putExtra("val",0);
                startActivity(I);
                //TextView t1=(TextView)findViewById(R.id.tvt1);
                //t1.setText("                 Welcome to our app.This ia an initiative app to our society for people suffering from obesity\n\n\n Theory classes provide various information about obesity to know what kind of serious problem you really have.\nWe provide you with tweets from all leading health association to your knowledge.\nThe video exercises we provide are specially for obese people with lite movements instead of hard exercises for obese people to practice as it is very difficult for them to follow hard exercises.\nThese will provide maximum output for obese people to lose their unwanted fat.\n We have also added tools such as push up counter, task rater to test and evaluate yourselves.\n Thank you\n\n\n\t\t\t'Health is wealth'");

                                            }
                               }
        );

        b10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i=new Intent (Theorylist.this,recipemenu.class);
                startActivity(i);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i=new Intent (Theorylist.this,Dietlist.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",1);
                startActivity(I);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",2);
                startActivity(I);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",3);
                startActivity(I);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",4);
                startActivity(I);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",5);
                startActivity(I);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",6);
                startActivity(I);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",7);
                startActivity(I);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",8);
                startActivity(I);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                I.putExtra("val",9);
                startActivity(I);
            }
        });

    }
}