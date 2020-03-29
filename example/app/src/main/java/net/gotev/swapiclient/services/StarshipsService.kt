package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.foundation.asResponseByMappingItem
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

class StarshipsService : PagedResponseServiceFactory {
    override val title: String
        get() = "Starships"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService {
        return { pageNumber ->
            swapiClient.starships(pageNumber).asResponseByMappingItem {
                Cell(
                    model = Cell.Model(
                        title = it.name,
                        subtitle = "Class: ${it.starshipClass}"
                    ),
                    onClick = {
                        onItemClick(it)
                    }
                )
            }
        }
    }
}
