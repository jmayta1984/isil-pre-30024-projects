package pe.isil.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btBlink, btSlide, btRotate, btZoom;
    private ImageView ivLogo;

    private void initViews() {
        btBlink = findViewById(R.id.btBlink);
        btSlide = findViewById(R.id.btSlide);
        btRotate = findViewById(R.id.btRotate);
        btZoom = findViewById(R.id.btZoom);
        ivLogo = findViewById(R.id.ivLogo);
    }

    private void initViewListeners() {

        btBlink.setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
            ivLogo.startAnimation(animation);
        });

        btSlide.setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide);
            ivLogo.startAnimation(animation);
        });

        btRotate.setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
            ivLogo.startAnimation(animation);
        });

        btZoom.setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom);
            ivLogo.startAnimation(animation);
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewListeners();
    }
}