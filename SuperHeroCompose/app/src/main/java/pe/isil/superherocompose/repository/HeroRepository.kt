package pe.isil.superherocompose.repository

import android.util.Log
import pe.isil.superherocompose.data.model.Hero
import pe.isil.superherocompose.data.model.HeroResponse
import pe.isil.superherocompose.data.remote.ApiClient
import pe.isil.superherocompose.data.remote.HeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepository(

    private val heroService: HeroService = ApiClient.getHeroService()
) {
    fun searchHero(name: String, callback: (ArrayList<Hero>) -> Unit){

        val searchHero = heroService.searchHero(name)

        searchHero.enqueue(object: Callback<HeroResponse> {
            override fun onResponse(call: Call<HeroResponse>, response: Response<HeroResponse>) {
                if (response.isSuccessful) {
                    callback((response.body() as HeroResponse).heroes)
                }
            }

            override fun onFailure(call: Call<HeroResponse>, t: Throwable) {
                t.message?.let { Log.d("HeroRepository", it) }
            }
        })

    }
}