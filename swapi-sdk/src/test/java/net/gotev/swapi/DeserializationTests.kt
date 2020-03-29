package net.gotev.swapi

import org.junit.Test

class DeserializationTests {
    @Test
    fun deserializeFilms() {
        allPagedFilms()
    }

    @Test
    fun deserializeCharacters() {
        allPagedCharacters()
    }

    @Test
    fun deserializePlanets() {
        allPagedPlanets()
    }

    @Test
    fun deserializeSpecies() {
        allPagedSpecies()
    }

    @Test
    fun deserializeStarships() {
        allPagedStarships()
    }

    @Test
    fun deserializeVehicles() {
        allPagedVehicles()
    }

    @Test
    fun mapVehiclesManufacturers() {
        allPagedVehicles()
            .resultsList()
            .map {
                it.rawManufacturers.mapManufacturersOrFail()
            }
    }

    @Test
    fun mapStarshipsManufacturers() {
        allPagedStarships()
            .resultsList()
            .map {
                it.rawManufacturers.mapManufacturersOrFail()
            }
    }

    @Test
    fun mapCharactersEyeColors() {
        allPagedCharacters()
            .resultsList()
            .map {
                it.rawEyeColors.mapEyeColorsOrFail()
            }
    }

    @Test
    fun mapCharactersSkinColors() {
        allPagedCharacters()
            .resultsList()
            .map {
                it.rawSkinColors.mapSkinColorsOrFail()
            }
    }

    @Test
    fun mapCharactersHairColors() {
        allPagedCharacters()
            .resultsList()
            .map {
                it.rawHairColors.mapHairColorsOrFail()
            }
    }
}
