package pe.isi.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btRed, btBlue, btGreen;

    private void initViews() {
        btRed = findViewById(R.id.btRed);
        btBlue = findViewById(R.id.btBlue);
        btGreen = findViewById(R.id.btGreen);
    }

    private void initViewListeners() {
        btRed.setOnClickListener(view -> {
            Fragment fragment = new RedFragment();
            replace(fragment);
        });

        btBlue.setOnClickListener(view -> {
            Fragment fragment = new BlueFragment();
            replace(fragment);
        });

        btGreen.setOnClickListener(view -> {
            Fragment fragment = new GreenFragment();
            replace(fragment);
        });
    }

    private void replace(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.flBody, fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewListeners();
    }
}