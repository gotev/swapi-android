package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.foundation.asResponseByMappingItem
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

class CharactersService : PagedResponseServiceFactory {
    override val title: String
        get() = "Characters"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService {
        return { pageNumber ->
            swapiClient.characters(pageNumber).asResponseByMappingItem {
                Cell(
                    model = Cell.Model(
                        title = it.name,
                        subtitle = it.gender.name
                    ),
                    onClick = {
                        onItemClick(it)
                    }
                )
            }
        }
    }
}
