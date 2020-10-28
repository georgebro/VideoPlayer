package com.example.video;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    private VideoView myVideoView;
    private MediaController mediaController;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myVideoView = findViewById(R.id.myVideoView);
        mediaController = new MediaController(this);
        myVideoView.setMediaController(mediaController);
    }

    public void play(View view) {
        if(uri == null){
            uri = Uri.parse("https://www.w3schools.com/html/mov_bbb.mp4"); // Need INTERNET permission
            myVideoView.setVideoURI(uri);
        }

        myVideoView.start();
        mediaController.show(3000);
    }

    public void pause(View view) {
        if(uri != null)
            myVideoView.pause();
    }

    public void Stop(View view) {
        if(uri != null){
            myVideoView.stopPlayback();
            myVideoView.setVisibility(View.GONE);
            myVideoView.setVisibility(View.VISIBLE);
            uri = null;
        }
    }
}
