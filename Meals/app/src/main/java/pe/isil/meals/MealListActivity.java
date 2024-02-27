package pe.isil.meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MealListActivity extends AppCompatActivity {

    private RecyclerView rvMealList;
    private MealAdapter mealAdapter;
    private List<Meal> meals = new ArrayList<>();
    private MealRepository mealRepository;

    private static final String CATEGORY_NAME = "category";

    private void initViews() {
        rvMealList = findViewById(R.id.rvMealList);
    }

    private void setupRepository() {
        mealRepository = new MealRepository();
        mealRepository.setShowMealsInterface(meals -> {
            this.meals = meals;
            mealAdapter.setMeals(meals);
            mealAdapter.notifyDataSetChanged();
        });

    }

    private void loadData() {
        mealRepository.getMeals(getIntent().getStringExtra(CATEGORY_NAME));
    }

    private void setupRecyclerView() {
        mealAdapter = new MealAdapter(meals);
        rvMealList.setAdapter(mealAdapter);
        rvMealList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);
        initViews();
        setupRepository();
        loadData();
        setupRecyclerView();
    }
}