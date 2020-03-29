package net.gotev.swapi

import net.gotev.swapi.models.Character
import net.gotev.swapi.models.Film
import net.gotev.swapi.models.Planet
import net.gotev.swapi.models.Specie
import net.gotev.swapi.models.Starship
import net.gotev.swapi.models.Vehicle

fun Any.allPagedFilms() = listOf(pagedResponse("films_page1.json", Film::class.java))

fun Any.allPagedCharacters() = (1..9).map { number ->
    pagedResponse("people_page$number.json", Character::class.java)
}

fun Any.allPagedPlanets() = (1..7).map { number ->
    pagedResponse("planets_page$number.json", Planet::class.java)
}

fun Any.allPagedSpecies() = (1..4).map { number ->
    pagedResponse("species_page$number.json", Specie::class.java)
}

fun Any.allPagedStarships() = (1..4).map { number ->
    pagedResponse("starships_page$number.json", Starship::class.java)
}

fun Any.allPagedVehicles() = (1..4).map { number ->
    pagedResponse("vehicles_page$number.json", Vehicle::class.java)
}
