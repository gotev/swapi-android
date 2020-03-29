package net.gotev.swapiclient.services

import net.gotev.swapiclient.foundation.PagedResponseOnError
import net.gotev.swapiclient.foundation.PagedResponseService
import net.gotev.swapiclient.items.Cell

interface PagedResponseServiceFactory {
    val title: String
    fun service(onItemClick: (Any) -> Unit): PagedResponseService
    val onError: PagedResponseOnError
        get() = {
            Cell(
                model = Cell.Model(
                    title = "Something bad happened. Pull down to retry.",
                    subtitle = "$it"
                )
            )
        }
}
