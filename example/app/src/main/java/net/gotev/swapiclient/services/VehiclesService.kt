package net.gotev.swapiclient.services

import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.foundation.asResponseByMappingItem
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

class VehiclesService : PagedResponseServiceFactory {
    override val title = "Vehicles"

    override fun service(onItemClick: (Any) -> Unit): PagedResponseService = { pageNumber ->
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
