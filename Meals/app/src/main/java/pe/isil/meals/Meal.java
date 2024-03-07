package pe.isil.meals;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Meal {

    @Ignore
    @SerializedName("strMeal")
    private String name;

    @Ignore
    @SerializedName("strMealThumb")
    private String urlImage;

    @PrimaryKey
    @SerializedName("idMeal")
    @NonNull
    private String id;

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }
}
