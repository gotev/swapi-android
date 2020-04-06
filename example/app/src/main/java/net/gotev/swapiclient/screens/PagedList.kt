package net.gotev.swapiclient.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_base.recycler_view
import kotlinx.android.synthetic.main.fragment_paged.*
import net.gotev.recycleradapter.paging.PagingAdapter
import net.gotev.swapiclient.R
import net.gotev.swapiclient.foundation.AdapterItemsPageKeyedDataSource
import net.gotev.swapiclient.foundation.BaseFragment
import net.gotev.swapiclient.foundation.defaultPagedList

class PagedList : BaseFragment() {

    private val onItemClick: (Any) -> Unit
        get() = {
            viewModel.detail = it
            findNavController().navigate(PagedListDirections.openDetail())
        }

    private val pagingAdapter by lazy {
        PagingAdapter(
            dataSource = {
                AdapterItemsPageKeyedDataSource(
                    scope = lifecycleScope,
                    service = viewModel.service.service(onItemClick),
                    onError = viewModel.service.onError
                )
            },
            config = defaultPagedList()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_paged, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = pagingAdapter
        setActionBarTitleAndSubtitle(title = viewModel.service.title)

        swipe_layout.apply {
            isRefreshing = true

            setOnRefreshListener {
                pagingAdapter.reload()
            }
        }

        pagingAdapter.startObserving(
            owner = this,
            onLoadingComplete = {
                swipe_layout.isRefreshing = false
            }
        )
    }
}
