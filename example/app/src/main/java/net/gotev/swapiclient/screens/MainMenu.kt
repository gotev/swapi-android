package net.gotev.swapiclient.screens

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import net.gotev.swapiclient.foundation.BaseFragment
import net.gotev.swapiclient.items.Cell
import net.gotev.swapiclient.services.CharactersService
import net.gotev.swapiclient.services.FilmsService
import net.gotev.swapiclient.services.PagedResponseServiceFactory
import net.gotev.swapiclient.services.PlanetsService
import net.gotev.swapiclient.services.SpeciesService
import net.gotev.swapiclient.services.StarshipsService
import net.gotev.swapiclient.services.VehiclesService

class MainMenu : BaseFragment() {

    private fun openPagedList(service: PagedResponseServiceFactory) {
        viewModel.service = service
        findNavController().navigate(MainMenuDirections.openPagedList())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActionBarTitleAndSubtitle(
            title = "SWAPI Client",
            subtitle = "A SWAPI SDK + declarative programming demo"
        )

        render {
            +Cell(
                model = Cell.Model(
                    title = "Films",
                    subtitle = "All the films in the saga"
                ),
                onClick = { openPagedList(FilmsService()) }
            )

            +Cell(
                model = Cell.Model(
                    title = "Characters",
                    subtitle = "All the characters in the saga"
                ),
                onClick = { openPagedList(CharactersService()) }
            )

            +Cell(
                model = Cell.Model(
                    title = "Species",
                    subtitle = "All the species in the saga"
                ),
                onClick = { openPagedList(SpeciesService()) }
            )

            +Cell(
                model = Cell.Model(
                    title = "Planets",
                    subtitle = "All the planets in the saga"
                ),
                onClick = { openPagedList(PlanetsService()) }
            )

            +Cell(
                model = Cell.Model(
                    title = "Vehicles",
                    subtitle = "All the vehicles in the saga"
                ),
                onClick = { openPagedList(VehiclesService()) }
            )

            +Cell(
                model = Cell.Model(
                    title = "Starships",
                    subtitle = "All the starships in the saga"
                ),
                onClick = { openPagedList(StarshipsService()) }
            )
        }
    }
}
