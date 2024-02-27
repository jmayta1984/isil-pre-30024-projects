package pe.isil.meals;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private final CategoryService categoryService;
    private ShowCategoriesInterface showCategoriesInterface;

    public CategoryRepository() {
        categoryService = CategoryServiceFactory.getCategoryService();
    }

    public void setShowCategoriesInterface(ShowCategoriesInterface showCategoriesInterface) {
        this.showCategoriesInterface = showCategoriesInterface;
    }

    public void getCategories() {
        Call<CategoryResponse> getCategories = categoryService.getCategories();

        getCategories.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<CategoryResponse> call, @NonNull Response<CategoryResponse> response) {
                if (response.isSuccessful()) {
                    showCategoriesInterface.showCategories(response.body() != null ? response.body().getCategories() : new ArrayList<>());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CategoryResponse> call, @NonNull Throwable t) {
                Log.d("CategoryRepository", t.getMessage() != null ? t.getMessage() : "No throwable");
            }
        });
    }

    public interface ShowCategoriesInterface {
        void showCategories(List<Category> categories);
    }
}
