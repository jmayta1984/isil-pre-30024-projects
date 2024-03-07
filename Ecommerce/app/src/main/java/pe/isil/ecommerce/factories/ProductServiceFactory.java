package pe.isil.ecommerce.factories;

import pe.isil.ecommerce.data.remote.ApiClient;
import pe.isil.ecommerce.data.remote.ProductService;

public class ProductServiceFactory {

    private static ProductService productService = null;

    public static ProductService getProductService(){
        if (productService == null) {
            productService = ApiClient.getRetrofit().create(ProductService.class);
        }
        return productService;
    }
}
