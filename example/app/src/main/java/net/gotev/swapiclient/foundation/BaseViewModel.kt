package net.gotev.swapiclient.foundation

import androidx.lifecycle.ViewModel
import net.gotev.swapi.swapiClient
import net.gotev.swapiclient.fetcher.fetcher
import net.gotev.swapiclient.services.PagedResponseServiceFactory

class BaseViewModel : ViewModel() {

    lateinit var service: PagedResponseServiceFactory
    var detail: Any? = null

    val filmsFetcher = fetcher { swapiClient.films().results }

    val charactersFetcher = fetcher { swapiClient.characters().results }

    val planetsFetcher = fetcher { swapiClient.planets().results }

    val speciesFetcher = fetcher { swapiClient.species().results }

    val vehiclesFetcher = fetcher { swapiClient.vehicles().results }

    val starshipsFetcher = fetcher { swapiClient.starships().results }
}
