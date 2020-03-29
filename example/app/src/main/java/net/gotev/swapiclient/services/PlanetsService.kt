package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.foundation.asResponseByMappingItem
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

class PlanetsService : PagedResponseServiceFactory {
    override val title: String
        get() = "Planets"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService {
        return { pageNumber ->
            swapiClient.planets(pageNumber).asResponseByMappingItem {
                Cell(
                    model = Cell.Model(
                        title = it.name,
                        subtitle = "Population: ${it.population}"
                    ),
                    onClick = {
                        onItemClick(it)
                    }
                )
            }
        }
    }
}
