package net.gotev.swapiclient.items

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import net.gotev.recycleradapter.AdapterItem
import net.gotev.recycleradapter.RecyclerAdapterViewHolder
import net.gotev.swapiclient.R

internal class Title(
    private val title: String
) : AdapterItem<Title.Holder>(title) {

    override fun getLayoutId() = R.layout.item_title

    override fun bind(firstTime: Boolean, holder: Holder) {
        holder.title.text = title
    }

    class Holder(itemView: View) : RecyclerAdapterViewHolder(itemView) {
        val title = findViewById(R.id.title) as AppCompatTextView
    }
}
