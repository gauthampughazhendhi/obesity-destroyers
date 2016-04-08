package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;


public class Video extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener ,YouTubeThumbnailView.OnInitializedListener {

	/**
	 * Called when the activity is first created.
	 */
	WebView webView;
	YouTubePlayer youTubePlayer;
	public static final String API_KEY = "AIzaSyB9q8udbmku1SPoc8-xIyTyGnjfq7Vb1pI";
	public static final String VIDEO_ID = "o7VVHhK9zf0";



	YouTubeThumbnailLoader youTubeThumbnailLoader;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_view);
        /* THIS DOES NOT WORK IF YOU DON'T HAVE h264 Codec.
        String customHtml = "<html><body><iframe width=\"320\" height=\"480\" src="+videolink+"frameborder=\"0\"></iframe></body></html>";
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginsEnabled(true);
        webView.loadData(customHtml, "text/html", "UTF-8");

        */


		YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeplayerview);

		youTubePlayerView.initialize(API_KEY, this);


		//Intent lVideoIntent = new Intent(null,Uri.parse("ytv://"+v), this, OpenYouTubePlayerActivity.class);

		//startActivity(lVideoIntent);
	}


		@Override
		public void onInitializationFailure (YouTubePlayer.Provider provider,

				YouTubeInitializationResult result){
			String v;
			Intent i = getIntent();
			v = i.getStringExtra("text");
			Toast.makeText(getApplicationContext(),
					v,
					Toast.LENGTH_LONG).show();
		}

		@Override
		public void onInitializationSuccess (YouTubePlayer.Provider provider, YouTubePlayer player,
		boolean wasRestored){
			String v;
			Intent i = getIntent();
			v = i.getStringExtra("text");
			youTubePlayer = player;
			youTubePlayer.setFullscreen(true);

			if (!wasRestored) {
				player.cueVideo(v);
			}
		}

		@Override
		public void onInitializationFailure (YouTubeThumbnailView thumbnailView,
				YouTubeInitializationResult error){
			int duration = Toast.LENGTH_LONG;
			Toast t = Toast.makeText(Video.this, "Unable to load", Toast.LENGTH_LONG);

		}

		@Override
		public void onInitializationSuccess (YouTubeThumbnailView thumbnailView,
				YouTubeThumbnailLoader thumbnailLoader){

			String v;
			Intent i = getIntent();
			v = i.getStringExtra("text");

			youTubeThumbnailLoader = thumbnailLoader;
			thumbnailLoader
					.setOnThumbnailLoadedListener(new ThumbnailLoadedListener());

			youTubeThumbnailLoader.setVideo(v);

		}

		private final class ThumbnailLoadedListener implements
				YouTubeThumbnailLoader.OnThumbnailLoadedListener {

			@Override
			public void onThumbnailError(YouTubeThumbnailView arg0, YouTubeThumbnailLoader.ErrorReason arg1) {
				int duration = Toast.LENGTH_LONG;
				Toast t = Toast.makeText(Video.this, "Unable to load", duration);
			}

			@Override
			public void onThumbnailLoaded(YouTubeThumbnailView arg0, String arg1) {

			}

		}

}
