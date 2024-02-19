package pe.isil.superhero;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HeroRepository {

    private ShowHeroesInterface showHeroesInterface;

    public void setShowHeroesInterface(ShowHeroesInterface showHeroesInterface) {
        this.showHeroesInterface = showHeroesInterface;
    }

    public void searchHeroes(String heroName) {

        Retrofit retrofit = ApiClient.getRetrofit();
        HeroService heroService = retrofit.create(HeroService.class);

        Call<HeroResponse> searchHero = heroService.searchHero(heroName);

        searchHero.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(@NonNull Call<HeroResponse> call, @NonNull Response<HeroResponse> response) {
                if (response.isSuccessful()){
                    HeroResponse heroResponse = response.body();
                    showHeroesInterface.showHeroes(Objects.requireNonNull(heroResponse).getHeroes());
                }
            }

            @Override
            public void onFailure(@NonNull Call<HeroResponse> call, Throwable t) {
                Log.d("HeroRepository", t.toString());
            }
        });
    }

    public interface ShowHeroesInterface {
        void showHeroes(ArrayList<Hero> heroes);
    }
}
