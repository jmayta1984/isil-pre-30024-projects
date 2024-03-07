package pe.isil.meals;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface MealDao {

    @Insert
    void insert (Meal meal);

    @Delete
    void delete(Meal meal);
}
