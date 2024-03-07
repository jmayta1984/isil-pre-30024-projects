package pe.isil.ecommerce.data.local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class ProductEntity  {

    @PrimaryKey
    private int id;

    private String name;

    @ColumnInfo(name = "url_image")
    private String urlImage;
    private String description;
    private int quantity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
