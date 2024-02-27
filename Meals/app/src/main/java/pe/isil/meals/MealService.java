package pe.isil.meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {

    @GET("filter.php")
    Call<MealResponse> getMeals(@Query("c") String name);
}
