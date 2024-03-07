package pe.isil.meals;

public class MealDaoFactory {

    private static MealDao mealDao = null;

    public static MealDao getMealDao() {
        if (mealDao == null) {
            mealDao = AppDatabase.getInstance(MyApplication.getContext()).mealDao();
        }
        return mealDao;
    }
}
