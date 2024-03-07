package pe.isil.meals;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("strCategory")
    private String name;

    @SerializedName("strCategoryThumb")
    private String urlImage;

    @SerializedName("strCategoryDescription")
    private String description;

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getDescription() {
        return description;
    }
}
