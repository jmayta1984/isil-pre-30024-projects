package pe.isil.meals;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepository {
    private final MealService mealService;
    private final MealDao mealDao;
    private ShowMealsInterface showMealsInterface;

    public MealRepository() {
        mealService = MealServiceFactory.getMealService();
        mealDao = MealDaoFactory.getMealDao();
    }

    public void setShowMealsInterface(ShowMealsInterface showMealsInterface) {
        this.showMealsInterface = showMealsInterface;
    }

    public void getMeals(String name) {
        Call<MealResponse> getMeals = mealService.getMeals(name);

        getMeals.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                if (response.isSuccessful()) {
                    showMealsInterface.showMeals(response.body() != null ? response.body().getMeals() : new ArrayList<>());
                }
            }

            @Override
            public void onFailure(@NonNull Call<MealResponse> call, @NonNull Throwable t) {
                Log.d("MealRepository", t.getMessage() != null ? t.getMessage() : "No throwable");
            }
        });
    }

    public interface ShowMealsInterface {
        void showMeals(List<Meal> meals);
    }
}
