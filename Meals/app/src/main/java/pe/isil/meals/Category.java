package pe.isil.meals;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("strCategory")
    private String name;

    @SerializedName("strCategoryThumb")
    private String urlImage;

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
