package pe.isil.superhero;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HeroService {

    @GET("10157703717092094/search/{heroName}")
    Call<HeroResponse> searchHero(@Path("heroName") String heroName);
}
