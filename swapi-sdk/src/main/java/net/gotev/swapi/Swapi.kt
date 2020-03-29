package net.gotev.swapi

import net.gotev.swapi.models.Character
import net.gotev.swapi.models.Film
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.models.Planet
import net.gotev.swapi.models.Specie
import net.gotev.swapi.models.Starship
import net.gotev.swapi.models.Vehicle
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface Swapi {
    @GET("films")
    suspend fun films(@Query("page") page: Int = 1): PagedResponse<Film>

    @GET
    suspend fun film(@Url url: String): Film

    @GET("people")
    suspend fun characters(@Query("page") page: Int = 1): PagedResponse<Character>

    @GET
    suspend fun character(@Url url: String): Character

    @GET("planets")
    suspend fun planets(@Query("page") page: Int = 1): PagedResponse<Planet>

    @GET
    suspend fun planet(@Url url: String): Planet

    @GET("species")
    suspend fun species(@Query("page") page: Int = 1): PagedResponse<Specie>

    @GET
    suspend fun specie(@Url url: String): Specie

    @GET("vehicles")
    suspend fun vehicles(@Query("page") page: Int = 1): PagedResponse<Vehicle>

    @GET
    suspend fun vehicle(@Url url: String): Vehicle

    @GET("starships")
    suspend fun starships(@Query("page") page: Int = 1): PagedResponse<Starship>

    @GET
    suspend fun starship(@Url url: String): Starship
}
