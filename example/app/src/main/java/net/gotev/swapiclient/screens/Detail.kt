package net.gotev.swapiclient.screens

import android.os.Bundle
import android.view.View
import net.gotev.recycleradapter.ext.RenderableItems
import net.gotev.recycleradapter.ext.renderableItems
import net.gotev.swapi.interfaces.HasClimates
import net.gotev.swapi.interfaces.HasEyeColors
import net.gotev.swapi.interfaces.HasHairColors
import net.gotev.swapi.interfaces.HasManufacturers
import net.gotev.swapi.interfaces.HasProducers
import net.gotev.swapi.interfaces.HasSkinColors
import net.gotev.swapi.interfaces.Identifiable
import net.gotev.swapi.interfaces.Purchasable
import net.gotev.swapi.interfaces.ShortDescriptable
import net.gotev.swapi.interfaces.Transportable
import net.gotev.swapi.models.Character
import net.gotev.swapi.models.Film
import net.gotev.swapi.models.Planet
import net.gotev.swapi.models.Specie
import net.gotev.swapiclient.foundation.BaseFragment
import net.gotev.swapiclient.items.Cell
import net.gotev.swapiclient.items.Title
import org.threeten.bp.format.DateTimeFormatter

class Detail : BaseFragment() {

    private fun cell(title: String, subtitle: String? = null) = Cell(Cell.Model(title, subtitle))

    private fun section(
        title: String,
        items: RenderableItems.() -> Unit
    ): RenderableItems = renderableItems {
        +Title(title)
        items(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActionBarTitleAndSubtitle(
            title = (viewModel.detail as? ShortDescriptable)?.shortDescription ?: "Detail"
        )

        val detail = viewModel.detail ?: run {
            render(
                cell(
                    title = "Whoops",
                    subtitle = "The detail you want to see is not there!"
                )
            )
            return
        }

        render {
            +detail.mapCharacterBasicInfo()
            +detail.mapFilmBasicInfo()
            +detail.mapPlanetBasicInfo()
            +detail.mapSpecieBasicInfo()
            +detail.mapProducers()
            +detail.mapSkinColors()
            +detail.mapHairColors()
            +detail.mapEyeColors()
            +detail.mapClimates()
            +detail.mapTransportable()
            +detail.mapManufacturers()
            +detail.mapPurchasable()
            +detail.mapIdentifiable()
        }
    }

    private fun Any.mapTransportable() = (this as? Transportable)?.let {
        section(title = "Transport Details") {
            +cell(name, "Name")
            +cell(model, "Model")
            +cell(cargoCapacity, "Cargo Capacity")
            +cell(consumablesDuration, "Consumables Duration")
            +cell(crewNumber, "Crew Number")
            +cell(length, "Length")
            +cell(maxAtmospheringSpeed, "Max Athmosphering Speed")
            +cell(maxPassengers, "Max Passengers")
        }
    }

    private fun Any.mapIdentifiable() = (this as? Identifiable)?.let {
        section(title = "Record information") {
            +cell(created.format(DateTimeFormatter.ISO_DATE_TIME), "Creation Date")
            +cell(edited.format(DateTimeFormatter.ISO_DATE_TIME), "Last Modification Date")
            +cell(url, "URL")
        }
    }

    private fun Any.mapPurchasable() = (this as? Purchasable)?.let {
        section(title = "Purchase information") {
            +cell(costInCredits, "Cost in credits")
        }
    }

    private fun Any.mapProducers() = (this as? HasProducers)?.let {
        section(title = "Producers") {
            +cell(rawProducers)
        }
    }

    private fun Any.mapSkinColors() = (this as? HasSkinColors)?.let {
        section(title = "Skin Colors") {
            +cell(rawSkinColors)
        }
    }

    private fun Any.mapHairColors() = (this as? HasHairColors)?.let {
        section(title = "Hair Colors") {
            +cell(rawHairColors)
        }
    }

    private fun Any.mapEyeColors() = (this as? HasEyeColors)?.let {
        section(title = "Eye Colors") {
            +cell(rawEyeColors)
        }
    }

    private fun Any.mapClimates() = (this as? HasClimates)?.let {
        section(title = "Climates") {
            +cell(rawClimates)
        }
    }

    private fun Any.mapManufacturers() = (this as? HasManufacturers)?.let {
        section(title = "Manufacturers") {
            +cell(rawManufacturers)
        }
    }

    private fun Any.mapCharacterBasicInfo() = (this as? Character)?.let {
        section(title ="Character Info") {
            +cell(name, "Name")
            +cell(birthYear, "Birth Year")
            +cell(height, "Height")
            +cell(mass, "Mass")
            +cell(gender.name, "Gender")
        }
    }

    private fun Any.mapPlanetBasicInfo() = (this as? Planet)?.let {
        section(title = "Planet Info") {
            +cell(name, "Name")
            +cell(rotationPeriod, "Rotation Period")
            +cell(orbitalPeriod, "Orbital Period")
            +cell(diameter, "Diameter in Km")
            +cell(gravity, "Gravity")
            +cell(population, "Population")
            +cell(surfaceWater, "Surface Water")
        }
    }

    private fun Any.mapFilmBasicInfo() = (this as? Film)?.let {
        section(title = "Film Info") {
            +cell(title, "Title")
            +cell(episodeNumber, "Episode Number")
            +cell(releaseDate.format(DateTimeFormatter.ISO_DATE), "Release Date")
            +cell(director, "Director")
            +cell(openingCrawl, "Opening Crawl")
        }
    }

    private fun Any.mapSpecieBasicInfo() = (this as? Specie)?.let {
        section(title = "Specie Info") {
            +cell(name, "Name")
            +cell(classification, "Classification")
            +cell(designation, "Designation")
            +cell(language, "Language")
            +cell(averageHeight, "Average Height")
            +cell(averageLifespan, "Average Lifespan")
        }
    }
}
