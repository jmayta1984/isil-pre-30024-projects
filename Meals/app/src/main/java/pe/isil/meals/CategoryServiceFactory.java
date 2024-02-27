package pe.isil.meals;

public class CategoryServiceFactory {
    private static CategoryService categoryService = null;

    public static CategoryService getCategoryService() {
        if (categoryService == null) {
            categoryService = ApiClient.getRetrofit().create(CategoryService.class);
        }
        return categoryService;
    }
}
