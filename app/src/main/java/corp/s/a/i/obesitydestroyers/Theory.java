package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Shiva Kishore on 9/6/2015.
 */
public class Theory extends Activity {
    int a;
    TextView t1,h;

    String list[]={"\nWhat is Obesity?","\nWhat is Body Mass Index(BMI)?","\nWhy do people become obese?","\nHow to overcome obesity?","\nOther dietary recommendations","\nFoods to AVOID when treating obesity","\nEfforts to be taken","\nOther Tips for Treating Obesity","\nTherapies to be followed"};
    String theory[]={"An obese person has accumulated so much body fat that it might have a negative effect on their health.\n\n\n If a person's body weight is at least 20% higher than it should be, he or she is considered obese.\n\n\n If your Body Mass Index (BMI) is between 25 and 29.9 you are considered overweight.\n\n\n If your BMI is 30 or over you are considered obese.","\nThe BMI is a statistical measurement derived from your height and weight.\n\n\n Although it is considered to be a useful way to estimate healthy body weight, it does not measure the percentage of body fat.\n\n\n BMI measurement can sometimes be misleading \nex: A muscleman may have a high BMI but have much less fat than an unfit person whose BMI is lower. However, in general, the BMI measurement can be a useful indicator for the 'average person'.",
    "Consuming too many calories.\n\n\n Leading a sedentary lifestyle. \n\n\n No proper sleep.\n\n\nChildren who have a television in their bedroom are much more likely to be obese or overweight than kids who do not, researchers from the Pennington Biomedical Research Center in Baton Rouge, LA, reported in the American Journal of Preventive Medicine(December 2012 issue).\n\n\n Endocrine disruptors, such as some foods that interfere with lipid metabolism.\n\n\nLack of sleep also results in your body producing less Leptin, a hormone that suppresses appetite.\n\n\n",
    "The quality of human health depends upon many pieces that not only include the health of your bodily systems, but also include a healthy diet, exercise, and spirituality.\n\n\n" +
            "1.Diet\n\n" +
            "   Eat more fiber.\n\n" +
            "   Skip the low-fat food products (contains high carbohydrates). \n\n   Add virgin coconut oil to your diet.\n\n" +
            "   Eat more vegetables and fruits. \n\n   Don’t skip breakfast during working days.\n\n\n   Eat frequent meals(low quantity).Eating five to six small meals throughout the day helps to speed up your metabolism. On the other hand, eating large meals only once or twice a day will actually slow down your metabolism.\n\n\n","Choose high-quality, organic, hormone- and antibiotic-free “grass-fed” meats.\n\n \n\n" +
            "Increase your omega-3 essential fatty acids by selecting wild-caught salmon,minimal-mercury tuna, and fish oil.\n\n\n" +
            "Choose organic, cage-free eggs.\n\n\n" +
            "Choose unpasteurized, raw dairy items that have live, active cultures (probiotics), such as yogurt and kefir.\n\n\n" +
            "Choose sprouted foods such as sprouted whole-grain bread and sprouted nuts and seeds.\n\n\n" +
            "Drink plenty of purified water throughout the day. Chronic dehydration can slow down metabolism.\n\n\n",
    "All simple or refined carbohydrates (white flour, white rice, white bread, pasta, cookies, cakes, crackers, processed snack foods, etc.). Read more about good carbs and bad carbs." +
            "\n\n\nAll foods containing refined sugar or synthetic sugar-substitutes such as aspartame. Alcoholic beverages in excess since they hinder the functioning of the immune and digestive systems" +
            "\n\n\nCarbonated soft drinks that cause blood pH levels to become acidic" +
            "\n\n\nBottom crawlers such as oysters, clams, and lobster that may contain toxic levels of mercury." +
            "\n\n\nDeep-sea fish such as tuna, mackerel, and swordfish that may contain toxic levels of mercury. Choose minimal-mercury tuna instead." +
            "\n\n\nFarm-raised fish that contain PCBs and not enough omega-3 essential fatty acids, due to their land-based diets. Choose wild-caught salmon instead." +
            "\n\n\nSodium nitrite found in processed foods such as hot dogs, lunch meats, and bacon." +
            "\n\n\nMono sodium glutamate (MSG) found in many foods as a flavor enhancer." +
            "\n\n\nHydrogenated or partially hydrogenated oils (trans fats) found in many processed foods, deep-fried foods, fast foods, and junk food because they contain trans fats." +
            "\n\n\nExcessive caffeine intake. While moderate amounts of caffeine may be beneficial in boosting metabolism, excessive caffeine consumption can disrupt the body’s systems, causing insomnia and digestive irregularity (constipation or diarrhea).",
    "Exercise:\n\n\nThe basic rule of weight loss is “Calories in,Calories out.” In order to effectively lose weight, you need to burn more calories than you consume.\n\n Therefore, exercise—and portion control when eating—are essential components in combating obesity.\n\n\n" +
            "If you suffer from obesity, you may have a difficult time keeping up with exercise programs that require flexibility and harsh movements. Fortunately, studies show that long, brisk walks are very effective in losing weight.\n\n Once you get to a point where you’re losing weight, you can take on more strenuous or more demanding aerobic exercises.\n\n The point is to start exercising, no matter how small your effort may seem in the beginning.\n\n",
    "Get proper sleep: \n\n\n Sleep deprivation slows metabolism. \n\nIf you have trouble falling asleep or staying asleep, try fast-acting melatonin.\n If sleeping problems are resistant to a quick fix, then see your health care professional to rule out any chronic conditions that may be causing insomnia.\n\n",
    "Try light therapy:\n\n\n Circadian Rhythm Disorder can cause hormone imbalances and disrupt your body’s natural hormone production schedule.\n This may hinder your ability to control your weight effectively.\n\n" +
            "\n\n\nConsider removing mercury dental fillings:\n\n\n   If you have silver fillings, get an evaluation from a mercury-free dentist who specializes in the safe removal of mercury amalgam fillings.\n\n Mercury in the body damages immune cells, which can be a contributing factor for weight gain and obesity-related chronic conditions",
    ""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theory);
        Intent I = this.getIntent();
        a = I.getIntExtra("val", 0);

        t1 = (TextView) findViewById(R.id.tvt1);
        h = (TextView) findViewById(R.id.tvhead);
        if (a == 0) {
            h.setText("\n\n   Introduction");
            t1.setText("         Welcome to our app\n\n\nThis ia an initiative app to our society for people suffering from obesity.\n\n\n Theory classes provide various information about obesity to know what kind of serious problem you really have.\n\n\n We provide you with tweets from all leading health association to your knowledge.\n\n\n The video exercises we provide are specially for obese people with lite movements instead of hard exercises for obese people to practice as it is very difficult for them to follow hard exercises.\n\n\n These will provide maximum output for obese people to lose their unwanted fat.\n\n\n We have also added tools such as push up counter, task rater,jog-o-meter to test and evaluate yourselves.\n\n\n We recommend you to use updated version of youtube app and jogging with your mobile at open space for accurate gps signals and ensure gps is on your mobile\n\n\n\t\t\t         'Health is wealth'");

        } else {

            h.setText(list[a - 1]);
            t1.setText(theory[a - 1]);

            switch (a) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;

            }
        }
    }
}
