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

interface SwapiOrigin : Swapi {
    @GET("films")
    override suspend fun films(@Query("page") page: Int): PagedResponse<Film>

    @GET
    override suspend fun film(@Url url: String): Film

    @GET("people")
    override suspend fun characters(@Query("page") page: Int): PagedResponse<Character>

    @GET
    override suspend fun character(@Url url: String): Character

    @GET("planets")
    override suspend fun planets(@Query("page") page: Int): PagedResponse<Planet>

    @GET
    override suspend fun planet(@Url url: String): Planet

    @GET("species")
    override suspend fun species(@Query("page") page: Int): PagedResponse<Specie>

    @GET
    override suspend fun specie(@Url url: String): Specie

    @GET("vehicles")
    override suspend fun vehicles(@Query("page") page: Int): PagedResponse<Vehicle>

    @GET
    override suspend fun vehicle(@Url url: String): Vehicle

    @GET("starships")
    override suspend fun starships(@Query("page") page: Int): PagedResponse<Starship>

    @GET
    override suspend fun starship(@Url url: String): Starship
}
