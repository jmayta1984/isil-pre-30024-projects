package pe.isil.meals;

import com.google.gson.annotations.SerializedName;

public class Meal {

    @SerializedName("strMeal")
    private String name;

    @SerializedName("strMealThumb")
    private String urlImage;

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
