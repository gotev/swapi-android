package net.gotev.swapiclient.foundation

import android.view.View
import androidx.paging.PagedList
import net.gotev.recycleradapter.AdapterItem
import net.gotev.swapi.extensions.pageNumber
import net.gotev.swapi.models.PagedResponse

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun defaultPagedList() = PagedList.Config.Builder()
    .setPageSize(50)
    .setPrefetchDistance(10)
    .setEnablePlaceholders(false) // removing this crashes the PagingAdapter
    .build()

inline fun <T : Any> PagedResponse<T>.asResponseByMappingItem(mapper: (T) -> AdapterItem<*>) =
    AdapterItemsPageKeyedDataSource.Response(
        items = results.map(mapper),
        nextPage = nextURL?.pageNumber(),
        previousPage = previousURL?.pageNumber()
    )
