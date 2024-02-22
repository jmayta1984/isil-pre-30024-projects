package pe.isil.mediaplayersample;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView vvSample;

    private void initView() {
        vvSample = findViewById(R.id.vvSample);
    }

    private void setupVideoView() {
        vvSample.setMediaController(new MediaController(this));
        String uriFile = "android.resource://pe.isil.mediaplayersample/"+  R.raw.sample;
        vvSample.setVideoPath(uriFile);
        vvSample.requestFocus();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        setupVideoView();
    }
}