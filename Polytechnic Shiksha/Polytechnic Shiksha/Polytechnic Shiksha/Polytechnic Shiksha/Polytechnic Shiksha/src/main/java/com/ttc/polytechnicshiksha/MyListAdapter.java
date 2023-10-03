package com.ttc.polytechnicshiksha;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Belal on 9/14/2017.
 */

//we need to extend the ArrayAdapter class as we are building an firstAdapter
public class MyListAdapter extends ArrayAdapter<Hero> implements YouTubePlayer.OnInitializedListener {

    //the list values in the List of type hero
    List<Hero> heroList;
    String a1="";
    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    ListView listView;
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private CardView cardview;

    private MyPlayerStateChangeListener playerStateChangeListener;
    private MyPlaybackEventListener playbackEventListener;
    private YouTubePlayer player;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<Hero> heroList) {
        super(context, resource, heroList);
        this.context = context;
        this.resource = resource;
        this.heroList = heroList;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        TextView textViewName = (TextView)view.findViewById(R.id.textViewName);
        TextView textViewTeam = (TextView)view.findViewById(R.id.textViewTeam);
        TextView textViewTeacherName = (TextView)view.findViewById(R.id.textViewTeacherName);

   //     Button buttonDelete = (Button) view.findViewById(R.id.buttonDelete);

        YouTubeThumbnailView youTubeView= (YouTubeThumbnailView) view.findViewById(R.id.video_thumbnail_image_view);;
        CardView cardview=(CardView)view.findViewById(R.id.card_view);

        //getting the hero of the specified position
        final Hero hero = heroList.get(position);

        //adding values to the list item
        //imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));

        textViewName.setText(hero.getTeam());
        textViewTeam.setText("TOPIC:- "+hero.getImage());
        if (hero.getTeacher().isEmpty())
        {
            textViewTeacherName.setVisibility(View.GONE);
        }

            textViewTeacherName.setText("By :- "+hero.getTeacher());


        youTubeView.initialize(Config.YOUTUBE_API_KEY,  new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                //when initialization is sucess, set the video id to thumbnail to load
             //   String showVideo =textViewName.getText().toString();
                String showVideo =hero.getName();
                String v1="/";


                String[] arrOfStr=showVideo.split(v1,5);
                if(arrOfStr.length>=3) {
                    a1 = arrOfStr[3];
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
                }

                Log.e(TAG, "thumbnail11:"+a1);
                youTubeThumbnailLoader.setVideo(a1);

                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        //when thumbnail loaded successfully release the thumbnail loader as we are showing thumbnail in firstAdapter
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
                        //print or show error when thumbnail load failed
                        Log.e(TAG, "Youtube Thumbnail Error");
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //print or show error when initialization failed
                Log.e(TAG, "Youtube Initialization Failure");

            }
        });

        playerStateChangeListener = new MyPlayerStateChangeListener();
        playbackEventListener = new MyPlaybackEventListener();
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b1=new Bundle();
                b1.putString("videoId",hero.getName());
            //    b1.putString("videoId",a1);

                Fragment ExpandFragment = new ExpandFragment();
                ExpandFragment.setArguments(b1);
                FragmentManager manager = ((Activity) context).getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.f2,ExpandFragment);
               // transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        //finally returning the view
        return view;
    }




    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        this.player = player;
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
       // player.setOnFullscreenListener(playbackfullsreenListener);
      //  player.setOnFullscreenListener(playfullscreen);

        if (!wasRestored) {
            player.loadVideo("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
           // errorReason.getErrorDialog(ge, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getContext().getString(R.string.player_error), errorReason.toString());
            Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }



    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }

    private void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            showMessage("Playing");
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().
            showMessage("Paused");
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.
            showMessage("Stopped");
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }

    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            // Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            // Called when an error occurs.
        }
    }

    //this method will remove the item from the list
    private void removeHero(final int position) {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");

        //if the response is positive in the alert
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //removing the item
                heroList.remove(position);

                //reloading the list
                notifyDataSetChanged();
            }
        });

        //if response is negative nothing is being done
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //creating and displaying the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
