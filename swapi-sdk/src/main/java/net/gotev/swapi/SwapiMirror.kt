package net.gotev.swapi

import net.gotev.swapi.models.Character
import net.gotev.swapi.models.Film
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.models.Planet
import net.gotev.swapi.models.Specie
import net.gotev.swapi.models.Starship
import net.gotev.swapi.models.Vehicle
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface SwapiMirror : Swapi {
    @GET("films/page{page}.json")
    override suspend fun films(@Path("page") page: Int): PagedResponse<Film>

    @GET
    override suspend fun film(@Url url: String): Film

    @GET("people/page{page}.json")
    override suspend fun characters(@Path("page") page: Int): PagedResponse<Character>

    @GET
    override suspend fun character(@Url url: String): Character

    @GET("planets/page{page}.json")
    override suspend fun planets(@Path("page") page: Int): PagedResponse<Planet>

    @GET
    override suspend fun planet(@Url url: String): Planet

    @GET("species/page{page}.json")
    override suspend fun species(@Path("page") page: Int): PagedResponse<Specie>

    @GET
    override suspend fun specie(@Url url: String): Specie

    @GET("vehicles/page{page}.json")
    override suspend fun vehicles(@Path("page") page: Int): PagedResponse<Vehicle>

    @GET
    override suspend fun vehicle(@Url url: String): Vehicle

    @GET("starships/page{page}.json")
    override suspend fun starships(@Path("page") page: Int): PagedResponse<Starship>

    @GET
    override suspend fun starship(@Url url: String): Starship
}
