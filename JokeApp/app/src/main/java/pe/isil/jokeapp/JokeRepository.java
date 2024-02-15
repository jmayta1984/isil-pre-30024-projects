package pe.isil.jokeapp;

import android.util.Log;
import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JokeRepository {

    private ShowJokeInterface showJokeInterface;

    public void setShowJokeInterface(ShowJokeInterface showJokeInterface) {
        this.showJokeInterface = showJokeInterface;
    }

    public void getJoke() {

        Retrofit retrofit = ApiClient.getRetrofit();

        JokeService jokeService = retrofit.create(JokeService.class);

        Call<Joke> getJoke = jokeService.getJoke();

        getJoke.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(@NonNull Call<Joke> call, @NonNull Response<Joke> response) {
                if (response.isSuccessful()) {
                    Joke joke = response.body();
                    showJokeInterface.showJoke(joke);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Joke> call, @NonNull Throwable t) {
                Log.d("MainActivity", t.toString());
            }
        });

    }

    public interface ShowJokeInterface {
        void showJoke(Joke joke);
    }
}
