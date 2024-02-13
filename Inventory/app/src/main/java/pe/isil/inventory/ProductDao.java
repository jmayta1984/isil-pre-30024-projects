package pe.isil.inventory;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ProductDao {

    @Query("select * from Product")
    List<Product> getAll();


    @Query("select * from Product where id=:id")
    Product getById(int id);

    @Insert
    void insert(Product... products);

    @Delete
    void delete(Product... products);

    @Update
    void update(Product... products);


}
