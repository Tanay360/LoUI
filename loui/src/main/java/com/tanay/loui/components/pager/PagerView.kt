package com.tanay.loui.components.pager

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.tanay.loui.Dp
import com.tanay.loui.components.Column
import com.tanay.loui.components.ColumnScope
import com.tanay.loui.size

class PagerViewAdapter<Item : Any>(
    private val view: ColumnScope.(Item, Int) -> Unit,
    private val items: List<Item>,
): RecyclerView.Adapter<PagerViewAdapter.ViewHolder>() {
    class ViewHolder(val view: LinearLayout): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.context.Column {
            size(Dp.FILL, Dp.FILL)
        })
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        view(ColumnScope(holder.view), items[position], position)
    }

    override fun getItemCount() = items.size
}