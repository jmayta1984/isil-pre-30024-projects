package pe.isil.superhero;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HeroResponse {

    @SerializedName("results")
    private ArrayList<Hero> heroes;

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }


}
