package pe.isil.ecommerce.data.model;

import com.google.gson.annotations.SerializedName;

public class Product {

    private int id;

    @SerializedName("title")
    private String name;

    @SerializedName("thumbnail")
    private String urlImage;
    private String description;

    private int price;


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

    public int getPrice() {
        return price;
    }
}
