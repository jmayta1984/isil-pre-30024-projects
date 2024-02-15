package pe.isil.jokeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tvJoke;
    private Button btGetJoke;
    private JokeRepository jokeRepository;

    private void initViews() {
        tvJoke = findViewById(R.id.tvJoke);
        btGetJoke = findViewById(R.id.btGetJoke);
    }

    private void initViewListeners() {
        btGetJoke.setOnClickListener(view -> {
            jokeRepository.getJoke();
        });
    }

    private void setupRepository() {
        jokeRepository = new JokeRepository();
        jokeRepository.setShowJokeInterface(joke -> {
            tvJoke.setText(joke.getJoke());
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewListeners();
        setupRepository();
    }
}