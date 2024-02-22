package pe.isil.mediaplayersample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btPlay, btPause;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewListeners();
        setupMediaPlayer();
    }

    private void initViews() {
        btPlay = findViewById(R.id.btPlay);
        btPause = findViewById(R.id.btPause);
    }

    private void initViewListeners() {
        btPlay.setOnClickListener(view -> {
            mediaPlayer.start();
        });

        btPause.setOnClickListener(view -> {
            mediaPlayer.pause();
        });
    }

    private void setupMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sample);

    }
}