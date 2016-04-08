package corp.s.a.i.obesitydestroyers;

import android.app.ListActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.CollectionTimeline;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import com.twitter.sdk.android.tweetui.TweetViewAdapter;
import com.twitter.sdk.android.tweetui.TweetViewFetchAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.Arrays;
import java.util.List;

import corp.s.a.i.obesitydestroyers.R;

public class tweet extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("@ObesityCourse")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);


        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) findViewById(R.id.refresher);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()

                                         {
                                             @Override
                                             public void onRefresh() {
                                                 swipeLayout.setRefreshing(true);
                                                 adapter.refresh(new Callback<TimelineResult<Tweet>>() {
                                                     @Override
                                                     public void success(Result<TimelineResult<Tweet>> result) {
                                                         swipeLayout.setRefreshing(false
                                                         );
                                                     }

                                                     @Override
                                                     public void failure(TwitterException exception) {
                                                         // Toast or some other action
                                                     }
                                                 });
                                             }

                                         }

        );

    }

}



