package pe.isil.ecommerce.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(ProductEntity productEntity);

    @Delete
    void delete(ProductEntity productEntity);

    @Update
    void update(ProductEntity productEntity);

    @Query("select * from products")
    List<ProductEntity> fetchAll();

    @Query("select * from products where id=:id")
    ProductEntity fetchById(String id);
}
