package pe.isil.meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity {

    private RecyclerView rvCategoryList;
    private CategoryAdapter categoryAdapter;
    private List<Category> categories = new ArrayList<>();
    private CategoryRepository categoryRepository;

    private static final String CATEGORY_NAME = "category";
    private static final String CATEGORY_IMAGE = "image";
    private static final String CATEGORY_DESCRIPTION = "description";

    private void initViews() {
        rvCategoryList = findViewById(R.id.rvCategoryList);
    }

    private void setupRepository() {
        categoryRepository = new CategoryRepository();
        categoryRepository.setShowCategoriesInterface(categories -> {
            this.categories = categories;
            categoryAdapter.setCategories(categories);
            categoryAdapter.notifyDataSetChanged();
        });

    }

    private void loadData() {
        categoryRepository.getCategories();
    }

    private void setupRecyclerView() {
        categoryAdapter = new CategoryAdapter(categories);
        categoryAdapter.setOnClickListener(position -> {
            Intent intent = new Intent(CategoryListActivity.this, MealListActivity.class);
            intent.putExtra(CATEGORY_NAME, categories.get(position).getName());
            intent.putExtra(CATEGORY_IMAGE, categories.get(position).getUrlImage());
            intent.putExtra(CATEGORY_DESCRIPTION, categories.get(position).getDescription());
            startActivity(intent);
        });
        rvCategoryList.setAdapter(categoryAdapter);
        rvCategoryList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        initViews();
        setupRepository();
        loadData();
        setupRecyclerView();
    }
}