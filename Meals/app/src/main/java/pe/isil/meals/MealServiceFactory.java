package pe.isil.meals;

public class MealServiceFactory {
    private static MealService mealService = null;

    public static MealService getMealService() {
        if (mealService == null) {
            mealService = ApiClient.getRetrofit().create(MealService.class);
        }
        return mealService;
    }
}
