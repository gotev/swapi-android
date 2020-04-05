package net.gotev.swapiclient.foundation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.gotev.recycleradapter.RecyclerAdapter
import net.gotev.recycleradapter.ext.RecyclerAdapterProvider
import net.gotev.swapiclient.MainActivity

open class BaseFragment : Fragment(), RecyclerAdapterProvider {
    override val recyclerAdapter by lazy { RecyclerAdapter() }

    internal val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(BaseViewModel::class.java)
    }

    internal var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        recyclerView = context?.let {
            RecyclerView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                layoutManager = LinearLayoutManager(it, RecyclerView.VERTICAL, false)
                adapter = recyclerAdapter
                addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            }
        }
        return recyclerView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerView?.adapter = null
        recyclerView = null
    }

    fun setActionBarTitleAndSubtitle(title: String, subtitle: String? = null) {
        (activity as? MainActivity)?.setTitleAndSubtitle(title, subtitle)
    }
}
