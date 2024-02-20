package pe.isil.superherocompose.data.model

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("results")
    val heroes: ArrayList<Hero>
)

data class Hero (
    val name: String,
    val biography: Biography,
    val image: HeroImage
)

data class Biography (
    @SerializedName("full-name")
    val fullName: String
)

data class HeroImage (
    val url: String
)
