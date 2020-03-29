package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.asResponseByMappingItem
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

class FilmsService : PagedResponseServiceFactory {
    override val title: String
        get() = "Films"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService {
        return { pageNumber ->
            swapiClient.films(pageNumber).asResponseByMappingItem {
                Cell(
                    model = Cell.Model(
                        title = it.title,
                        subtitle = "Episode ${it.episodeNumber}"
                    ),
                    onClick = {
                        onItemClick(it)
                    }
                )
            }
        }
    }
}
