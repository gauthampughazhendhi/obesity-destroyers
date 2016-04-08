package corp.s.a.i.obesitydestroyers;

import android.app.Activity;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Gautham Leo on 27-09-2015.
 */
public class show extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        TextView t=(TextView)findViewById(R.id.show);
        t.setText("\nInstructions:\n\n1.These Instruction are must while using jog-o-meter.\n\n2.Use jog-o-meter only  under open sky.\n\n3. Before clicking jog-o-meter please ensure that GPS is in on state and wait for 1-2 minutes so that the GPS signal becomes stable and in location settings of your mobile click High Accuracy mode.\n\n4.Under open sky the jog-o-meter can be used any number of times.\n\n5.The results  of the jog-o-meter will be accurate. ");
    }
}
