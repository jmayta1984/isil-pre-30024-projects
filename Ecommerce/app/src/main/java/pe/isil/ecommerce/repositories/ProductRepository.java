package pe.isil.ecommerce.repositories;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import pe.isil.ecommerce.data.local.ProductDao;
import pe.isil.ecommerce.data.local.ProductEntity;
import pe.isil.ecommerce.data.model.Product;
import pe.isil.ecommerce.data.remote.ProductService;
import pe.isil.ecommerce.factories.ProductDaoFactory;
import pe.isil.ecommerce.factories.ProductServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private final ProductService productService;
    private final ProductDao productDao;

    private ShowProductsInterface showProductsInterface;
    private ShowProductInterface showProductInterface;

    public void setShowProductsInterface(ShowProductsInterface showProductsInterface) {
        this.showProductsInterface = showProductsInterface;
    }

    public void setShowProductInterface(ShowProductInterface showProductInterface) {
        this.showProductInterface = showProductInterface;
    }


    public ProductRepository() {
        productService = ProductServiceFactory.getProductService();
        productDao = ProductDaoFactory.getProductDao();
    }

    public void getAll() {
        Call<List<Product>> getAll = productService.getAll();

        getAll.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    showProductsInterface.showProducts(response.body() != null ? response.body() : new ArrayList<>());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable t) {
                Log.d("ProductRepository", t.getMessage() != null ? t.getMessage() : "No exception");
            }
        });
    }


    public void getById(int id) {
        Call<Product> getById = productService.getProductById(id);

        getById.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(@NonNull Call<Product> call, @NonNull Response<Product> response) {
                if (response.isSuccessful()) {
                    showProductInterface.showProduct(response.body());
                }

            }

            @Override
            public void onFailure(@NonNull Call<Product> call, @NonNull Throwable t) {
                Log.d("ProductRepository", t.getMessage() != null ? t.getMessage() : "No exception");

            }
        });
    }

    public void add(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setDescription(product.getDescription());
        productEntity.setUrlImage(product.getUrlImage());
        productEntity.setName(product.getName());
        productEntity.setQuantity(1);
        new Thread(() -> {
            productDao.insert(productEntity);
        }).start();
    }

    public List<ProductEntity> getCartProducts() {
        return productDao.fetchAll();

    }

    public interface ShowProductsInterface {
        void showProducts(List<Product> products);
    }

    public interface ShowProductInterface {
        void showProduct(Product product);
    }

}
