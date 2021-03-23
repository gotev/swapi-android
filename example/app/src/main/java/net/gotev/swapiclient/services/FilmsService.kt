package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.foundation.asResponseByMappingItem
import net.gotev.swapiclient.items.Cell

class FilmsService : PagedResponseServiceFactory {
    override val title = "Films"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService = { pageNumber ->
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
