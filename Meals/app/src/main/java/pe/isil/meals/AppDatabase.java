package pe.isil.meals;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Meal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MealDao mealDao();

    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
