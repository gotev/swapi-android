package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.foundation.asResponseByMappingItem
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

class SpeciesService : PagedResponseServiceFactory {
    override val title: String
        get() = "Species"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService {
        return { pageNumber ->
            swapiClient.species(pageNumber).asResponseByMappingItem {
                Cell(
                    model = Cell.Model(
                        title = it.name,
                        subtitle = "Classification: ${it.classification}"
                    ),
                    onClick = {
                        onItemClick(it)
                    }
                )
            }
        }
    }
}
