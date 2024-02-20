package pe.isil.superherocompose.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://www.superheroapi.com/api.php/"

    private var retrofit: Retrofit? = null


    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit as Retrofit
    }

    fun getHeroService(): HeroService {
        return getRetrofit().create(HeroService::class.java)
    }
}