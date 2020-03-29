package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.asResponseByMappingItem
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

class VehiclesService : PagedResponseServiceFactory {
    override val title: String
        get() = "Vehicles"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService {
        return { pageNumber ->
            swapiClient.vehicles(pageNumber).asResponseByMappingItem {
                Cell(
                    model = Cell.Model(
                        title = it.name,
                        subtitle = "Class: ${it.vehicleClass}"
                    ),
                    onClick = {
                        onItemClick(it)
                    }
                )
            }
        }
    }
}
