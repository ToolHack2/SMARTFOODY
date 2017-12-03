package com.example.user.smartfoody.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.smartfoody.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by User on 12/3/2017.
 */

public class ViewVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyDO13t9y0dfJL7KaAYZixzXc-PSXvvQ-dU";
    public static final String VIDEO_ID = "AJ9Jg1PwRJo";
    private YouTubePlayerView youtubeView;
    private Button Click;
    private LinearLayout layout;
    private boolean up = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewvideo);

        //init
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubevideo);
        youtubeView.initialize(API_KEY, this);

        //
        final Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        final Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        //
        layout = (LinearLayout)findViewById(R.id.frameup);
        Click = (Button)findViewById(R.id.click);
        Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (up == false) {
                    layout.setVisibility(View.VISIBLE);
                    layout.startAnimation(slide_down);
                    Click.setBackgroundResource(R.drawable.ic_up);
                    up = true;
                }
                else
                {
                    layout.setVisibility(View.GONE);
                    layout.startAnimation(slide_up);
                    Click.setBackgroundResource(R.drawable.ic_down);
                    up = false;
                }
            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasrestore) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if (! wasrestore)
        {
            youTubePlayer.cueVideo(VIDEO_ID);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(ViewVideo.this, "Failed to Initialize!", Toast.LENGTH_SHORT).show();
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };



}
