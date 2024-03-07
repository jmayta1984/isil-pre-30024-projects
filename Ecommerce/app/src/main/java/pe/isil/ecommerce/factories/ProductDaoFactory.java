package pe.isil.ecommerce.factories;

import pe.isil.ecommerce.MyApplication;
import pe.isil.ecommerce.data.local.AppDatabase;
import pe.isil.ecommerce.data.local.ProductDao;

public class ProductDaoFactory {

    private static ProductDao productDao = null;

    public static ProductDao getProductDao() {

        if (productDao == null) {
            productDao = AppDatabase.getInstance(MyApplication.getContext()).productDao();
        }
        return productDao;
    }
}
