package pe.isil.superherocompose.data.remote

import pe.isil.superherocompose.data.model.HeroResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroService {

    @GET("10157703717092094/search/{heroName}")
    fun searchHero(@Path("heroName") name: String): Call<HeroResponse>

}