package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by shiva on 23/9/15.
 */
public class recipedesc extends Activity {
    String b[]={"\n\nGreen tea has been found to be very effective in weight loss and will help in treating weight loss without any dieting or weight loss pills." +
            "\n\n\nUse the best quality green tea leaves in boiling water and let it simmer for a few minutes.\n" +
            "\n\nDrink this green tea two to three times a day to see visible results in days.\n\n\n",
    "\n\nMix one teaspoon of apple cider vinegar and one teaspoon of lemon juice in a cup of lukewarm water.\n" +
            "\n\nDrink this glass of water on an empty stomach every day for two to three months.\n" +
            "\n\nYou will see visible results as water will keep you hydrated, apple cider vinegar will boost your metabolism and lemon will help in improving the taste of water.",
    "\n\nTake a teaspoon of honey and mix it in a glass of hot water.\n" +
            "\n\n\nAdd a teaspoon of lemon juice to this water mixture.\n" +
            "Drink this water the first thing in the morning when you get up and on an empty stomach.\n" +
            "\n\nRepeat this daily for two to three months to see an effective weight loss.",
    "\n\nIf you have the habit of drinking cold water, try to replace it with hot water.\n" +
            "\n\nHot water will help in eliminating the fat deposits in your body.\n" +
            "\n\nDrink hot water after every meal and make sure that you leave a gap of half an hour between the food and the water.\n" +
            "\n\nNever drink water immediately after eating.",
    "\n\nMint is known for its digestive properties and helps in healthy digestion.\n" +
            "\n" +
            "\nAdd a few drops of mint leaf juice extract in a glass of lukewarm water and mix it well.\n" +
            "\n\nDrink this mixture half an hour after you have taken a meal.\n" +
            "\n\nIt will help in easy digestion and will also boost your metabolism and is effective for weight loss on prolonged use.",
    "\n\nFennel is one of the very popular ancient home remedies to reduce appetite.\n" +
            "\n" +
            "\nBoil about 6 to 8 fennel seeds in a cup of water for a few minutes.\n" +
            "\n\nRemove of the seeds from the water and drink this plain water everyday in the morning on empty stomach to reduce your urge to eat.",
    "\n\nBefore going to bed, take a teaspoon of apple cider vinegar daily.\n" +
            "\n\nThis will help to burn your body fats effectively when you are sleeping.",
    "\n\nIt is a known fact that eating regularly food from hotels, restaurants or road side eateries will increase your weight like anything.\n" +
            "\n\nStick to homemade foods that are less in fats and oils.\n" +
            "\n\nAdding lots of greens, fruits and vegetables to your diet will help in fighting obesity.",
    "\n\nHoney is considered to be one of the best home remedies for a lot of ailments and also helps in weight loss.\n" +
            "\n\nAdd a teaspoon of honey with two teaspoons of lemon juice and a pinch of pepper in a glass of water.\n" +
            "\n\nMix it well and drink this glass of water the first thing in the morning every day.\n" +
            "You will never tend to gain weight.",
    "\n\nSpices are said to be very good ingredients that will help in reducing weight effectively and naturally.\n" +
            "\n" +
            "\nFor better and faster weight loss results, add two to three pieces of ginger, black pepper, cardamom, cinnamon and cloves to your daily green tea.\n" +
            "\n\nConsume this species filled tea for two to three times a day to see effective results in a month.",
    "\n\nTry to eat 10 to 12 fully developed curry leaves on an empty stomach every morning.\n" +
            "\n\nYou need to chew the leaves thoroughly and drink its juice.\n" +
            "\n\nContinue this for three to four months.",
    "\n\nInclude green leafy vegetables, tomatoes and carrots in your daily food intake.\n" +
            "\n\nA tomato salad for breakfast everyday morning will help in effectively reducing weight loss.\n" +
            "\n\nIncrease the quantity of vegetables and fruits that you consume and also go for low calorie foods that will help in quick filling up of your stomach.",
    "\n\nSoak a handful of jujube leaves in a cup of water.\n" +
            "\n\nLeave this for overnight and drink this water early next day morning.\n" +
            "You must drink the water on an empty stomach.\n" +
            "\n\nContinue this daily for over a month to see visible results.",
    "\n\nFinger millets need to be included in your daily diet plan.\n" +
            "\n\nIt is an ideal food to treat obesity and it helps in slow digestion.\n" +
            "\n\nThe carbohydrates will take a long time to get absorbed in your body and hence will prevent you from being obese.",
    "\n\nBrisk walking is one of the best ways to reduce obesity and to maintain a healthy body.\n" +
            "\n\nWorking out in the gym for about 30 to 45 minutes four to five days a week along with healthy diethabits will help in reducing your overweight."};

    TextView head,body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.untitled1);
        head=(TextView)findViewById(R.id.tvuh);
        body=(TextView)findViewById(R.id.tvubody);
        Intent i=getIntent();
        String s=i.getStringExtra("head");
        int j=i.getIntExtra("ind",0);
        head.setText(s);
        body.setText(b[j]);

    }
}
