package com.ttc.polytechnicshiksha;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class ExpandFragment extends Fragment implements YouTubePlayer.OnInitializedListener  {

    YouTubePlayerView youTubePlayerView;
    private static final int RECOVERY_REQUEST = 1;
    private String YOU_A_K;
    String TAG="VideoActivity";

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_expand, viewGroup, false);
       // YouTubePlayerSupportFragment youTubePlayerFragment = (YouTubePlayerSupportFragment) getActivity().getSupportFragmentManager()
        //      .findFragmentById(R.id.youtube_fragment);
        YouTubePlayerFragment youTubePlayerFragment = YouTubePlayerFragment.newInstance();

        YOU_A_K = BuildConfig.Y1+BuildConfig.Y2+BuildConfig.Y3+BuildConfig.Y4;
      //  youTubePlayerView=(YouTubePlayerView)view.findViewById(R.id.youtubeview);
        youTubePlayerFragment.initialize(YOU_A_K, this);


        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_fragment, youTubePlayerFragment).commit();
        //   LinearLayout root = view.findViewById(R.id.picker_launcher_buttons_layout);
        return view;



    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        //Bundle bundle = getActivity().getIntent().getExtras();
        Bundle bundle1 =getArguments();
      String showVideo = bundle1.getString("videoId");
        Log.e(TAG,"Video" +showVideo);
        // showVideo.
/*
        String v1="/";
        String[] arrOfStr=showVideo.split(v1,5);
        String a1=arrOfStr[3];

 */

        String v1="/";
        String  a1="";

        String[] arrOfStr=showVideo.split(v1,5);
        if(arrOfStr.length>=3) {
          a1  = arrOfStr[3];
        }
        if(a1.startsWith("watch"))
        {
            String v11="=";
            String a11="&";
            String[] arrOfStr1=a1.split(v11,5);
            Log.e("xxxxxxxxx",arrOfStr1[1]);
            String b1=arrOfStr1[1];
            String[] arrOfStr2=b1.split(a11,5);
            a1=arrOfStr2[0];
            //  Log.e("xxxxxxxxx",a1);



        }



        //   Log.e(TAG,"Video" +a1);
      //  Bundle bundle = getIntent().getExtras();
      //  String showVideo = bundle.getString("videoId");
        //Log.e(TAG,"Video" );
        youTubePlayer.cueVideo(a1);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
        } else {

            Toast.makeText(getActivity(), "Error Intializing Youtube Player", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            YOU_A_K = BuildConfig.Y1+BuildConfig.Y2+BuildConfig.Y3+BuildConfig.Y4;
            getYouTubePlayerProvider().initialize(YOU_A_K, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubePlayerView;
    }



}