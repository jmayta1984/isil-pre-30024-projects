package pe.isil.jokeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvJoke;
    private Button btGetJoke;

    private void initViews() {
        tvJoke = findViewById(R.id.tvJoke);
        btGetJoke = findViewById(R.id.btGetJoke);
    }

    private void initViewListeners() {
        btGetJoke.setOnClickListener(view -> getJoke());
    }

    private void getJoke() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://icanhazdadjoke.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JokeService jokeService = retrofit.create(JokeService.class);

        Call<Joke> getJoke = jokeService.getJoke();

        getJoke.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(@NonNull Call<Joke> call, @NonNull Response<Joke> response) {
                if (response.isSuccessful()) {

                    Joke joke = response.body();
                    tvJoke.setText(Objects.requireNonNull(joke).getJoke());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Joke> call, @NonNull Throwable t) {
                Log.d("MainActivity", t.toString());
            }
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