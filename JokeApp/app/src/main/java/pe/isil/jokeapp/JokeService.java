package pe.isil.jokeapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JokeService {

    @Headers({"Accept: application/json"})
    @GET("?")
    Call<Joke> getJoke();
}
