package net.gotev.swapiclient.items

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import net.gotev.recycleradapter.AdapterItem
import net.gotev.recycleradapter.RecyclerAdapterViewHolder
import net.gotev.swapiclient.R
import net.gotev.swapiclient.visible

internal class Cell(
    private val model: Model,
    val onClick: (() -> Unit)? = null,
    val onLongClick: (() -> Unit)? = null
) : AdapterItem<Cell.Holder>(model) {

    data class Model(val title: String, val subtitle: String? = null)

    override fun getLayoutId() = R.layout.item_cell

    override fun bind(firstTime: Boolean, holder: Holder) {
        holder.apply {
            title.text = model.title
            subtitle.text = model.subtitle ?: ""
            subtitle.visible(model.subtitle != null)
            accessory.visible(onClick != null)
        }
    }

    class Holder(itemView: View) : RecyclerAdapterViewHolder(itemView) {
        val title = findViewById(R.id.title) as AppCompatTextView
        val subtitle = findViewById(R.id.subtitle) as AppCompatTextView
        val accessory = findViewById(R.id.accessory) as ImageView
        val container = findViewById(R.id.container)

        init {
            container.setOnClickListener {
                (getAdapterItem() as? Cell)?.onClick?.invoke()
            }

            container.setOnLongClickListener {
                (getAdapterItem() as? Cell)?.onLongClick?.invoke()
                true
            }
        }
    }
}
