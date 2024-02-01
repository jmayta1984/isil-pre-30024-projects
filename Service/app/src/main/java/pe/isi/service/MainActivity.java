package pe.isi.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btStart, btStop;

    private void initViews() {
        btStart = findViewById(R.id.btStart);
        btStop = findViewById(R.id.btStop);
    }


    public void initViewListeners() {
        btStart.setOnClickListener(view -> {
            startService(new Intent(MainActivity.this, MyService.class));
        });
        btStop.setOnClickListener(view -> {
            stopService(new Intent(MainActivity.this, MyService.class));
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