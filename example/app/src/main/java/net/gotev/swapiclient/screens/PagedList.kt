package net.gotev.swapiclient.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import net.gotev.recycleradapter.paging.PagingAdapter
import net.gotev.swapiclient.foundation.AdapterItemsPageKeyedDataSource
import net.gotev.swapiclient.foundation.BaseFragment
import net.gotev.swapiclient.foundation.defaultPagedList

class PagedList : BaseFragment() {

    private val onItemClick: (Any) -> Unit
        get() = {
            viewModel.detail = it
            findNavController().navigate(PagedListDirections.openDetail())
        }

    private var pagingAdapter: PagingAdapter? = null
    private var swipeLayout: SwipeRefreshLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        pagingAdapter = PagingAdapter(
            dataSource = {
                AdapterItemsPageKeyedDataSource(
                    scope = lifecycleScope,
                    service = viewModel.service.service(onItemClick),
                    onError = viewModel.service.onError
                )
            },
            config = defaultPagedList()
        )

        swipeLayout = SwipeRefreshLayout(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            addView(recyclerView)
        }

        return swipeLayout?.apply {
            setOnRefreshListener {
                pagingAdapter?.reload()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView?.adapter = pagingAdapter
        setActionBarTitleAndSubtitle(title = viewModel.service.title)

        swipeLayout?.isRefreshing = true

        pagingAdapter?.startObserving(
            owner = this,
            onLoadingComplete = {
                swipeLayout?.isRefreshing = false
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        pagingAdapter = null
    }
}
