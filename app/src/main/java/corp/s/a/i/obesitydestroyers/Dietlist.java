package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by shiva on 22/9/15.
 */
public class Dietlist extends Activity{
    TextView mb,bf,lun,eb,din,et,day;
    ImageButton next,prev;
    int i=0;
    String mbev[]={"Hot lime juice with honey","Hot lime juice with honey (or) green tea without sugar","Green tea"};
    String bfast[]={"Oats or protein meal*", "Protein rich meal","Protein rich meal"};
    String lunch[]={"Small cup of rice + 3 different steamed vegetables (avoid potatoes) + 1 or 2 chapattis","1 Medium cup of wheat rice + 1 chapati+Steamed veg or veg salad","1 medium cup of wheat rice (or)2 chapattis + 1 cup of raw veg salad"};
    String ebev[]={"Green tea without sugar","Green tea without sugar","Green tea without sugar"};
    String dinner[]={"2 to 3 chapattis(numbers depend on your intake but not more than 3)","A cup of veg salad+2 chapattis","Protein rich meal"};
    String etake[]={"Small cup of sprouts (or) fiber content fruits","A cup of veg salad +2 chapattis","A small cup of sprouts(or)A small cup of fiber containing fruits"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietlist);
        mb=(TextView)findViewById(R.id.tvdietmrngbev);
        bf=(TextView)findViewById(R.id.tvdietbf);
        lun=(TextView)findViewById(R.id.tvdietlun);
        eb=(TextView)findViewById(R.id.tvdietevebev);
        din=(TextView)findViewById(R.id.tvdietdin);
        et=(TextView)findViewById(R.id.tvdietetake);
        next=(ImageButton)findViewById(R.id.btdietnext);
        prev=(ImageButton)findViewById(R.id.btdietprev);
        day=(TextView)findViewById(R.id.tvdietday);
        setdata(0);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 6)
                    i++;
                day.setText("Day "+(i+1));
                setdata(i);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0)
                    i--;
                day.setText("Day "+(i+1));
                setdata(i);
            }//
        });
    }
    public void setdata(int i)
    {
        int j=i%3;
     mb.setText(mbev[j]);
     bf.setText(bfast[j]);
     lun.setText(lunch[j]);
     eb.setText(ebev[j]);
     din.setText(dinner[j]);
     et.setText(etake[j]);
    }

}
