package pe.isil.superhero;

import com.google.gson.annotations.SerializedName;

public class Hero {

    private String name;

    private Biography biography;

    @SerializedName("image")
    private HeroImage heroImage;

    public String getName() {
        return name;
    }

    public String getFullName() {
        return biography.getFullName();
    }

    public String getUrl() {
        return heroImage.getUrl();
    }


    private class Biography {

        @SerializedName("full-name")
        private String fullName;

        public String getFullName() {
            return fullName;
        }
    }

    private class HeroImage {

        private String url;

        public String getUrl() {
            return url;
        }
    }
}
