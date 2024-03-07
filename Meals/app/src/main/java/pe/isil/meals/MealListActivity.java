package pe.isil.meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class MealListActivity extends AppCompatActivity {

    private RecyclerView rvMealList;
    private MealAdapter mealAdapter;
    private List<Meal> meals = new ArrayList<>();
    private MealRepository mealRepository;
    private ImageView ivCategoryImage;
    private CollapsingToolbarLayout ctCategory;

    private static final String CATEGORY_NAME = "category";
    private static final String CATEGORY_IMAGE = "image";
    private static final String CATEGORY_DESCRIPTION = "description";

    private void initViews() {
        ivCategoryImage = findViewById(R.id.ivCategoryImage);
        rvMealList = findViewById(R.id.rvMealList);
        ctCategory = findViewById(R.id.ctCategory);
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
        Glide.with(this).load(getIntent().getStringExtra(CATEGORY_IMAGE)).into(ivCategoryImage);
        ctCategory.setTitle(getIntent().getStringExtra(CATEGORY_NAME));
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