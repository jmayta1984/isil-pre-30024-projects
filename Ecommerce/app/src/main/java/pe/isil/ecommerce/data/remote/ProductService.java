package pe.isil.ecommerce.data.remote;

import java.util.List;

import pe.isil.ecommerce.data.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductService {

    @GET("products")
    Call<List<Product>> getAll();

    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int id);
}
