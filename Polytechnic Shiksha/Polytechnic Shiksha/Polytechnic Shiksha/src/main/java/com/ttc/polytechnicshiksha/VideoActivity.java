package com.ttc.polytechnicshiksha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class    VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
YouTubePlayerView youTubePlayerView;
    private static final int RECOVERY_REQUEST = 1;
    private String YOU_A_K;
    String TAG="VideoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
       youTubePlayerView=findViewById(R.id.youtubeview);
       YOU_A_K = BuildConfig.Y1+BuildConfig.Y2+BuildConfig.Y3+BuildConfig.Y4;
       youTubePlayerView.initialize(YOU_A_K, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        Bundle bundle = getIntent().getExtras();
        String showVideo = bundle.getString("videoId");
        Log.e(TAG,"Video" +showVideo);
       // showVideo.
        String v1="/";
        String[] arrOfStr=showVideo.split(v1,5);
        String a1=arrOfStr[3];

        Log.e(TAG,"Video" +a1);
        youTubePlayer.loadVideo(a1);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {

            Toast.makeText(this, "Error Intializing Youtube Player", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            YOU_A_K = BuildConfig.Y1+BuildConfig.Y2+BuildConfig.Y3+BuildConfig.Y4;
            getYouTubePlayerProvider().initialize(YOU_A_K, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubePlayerView;
    }


}
