package pe.isil.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewListeners();
    }
}