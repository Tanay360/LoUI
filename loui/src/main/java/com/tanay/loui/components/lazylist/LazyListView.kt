package com.tanay.loui.components.lazylist

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tanay.loui.components.Column
import com.tanay.loui.components.ColumnScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LazyList<Item: Any, Key: Any> @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {
    private lateinit var _adapter: LazyListAdapter<Item, Key>
    fun changeItems(newList: List<Item>) {
        _adapter.changeItems(newList)
    }

    fun changeItems(vararg newList: Item) {
        _adapter.changeItems(newList.toList())
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        @Suppress("UNCHECKED_CAST")
        if (adapter is LazyListAdapter<*, *>) {
            _adapter = adapter as LazyListAdapter<Item, Key>
        }
        super.setAdapter(adapter)
    }
}

class LazyListAdapter<Item : Any, Key : Any>(
    private val view: ColumnScope.(Item) -> Unit,
    items: List<Item>,
    private val key: (Item) -> Key
) : RecyclerView.Adapter<LazyListAdapter.ViewHolder>(), CoroutineScope {
    class ViewHolder(val view: LinearLayout) : RecyclerView.ViewHolder(view)

    private var list = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.context.Column{})
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        view(ColumnScope(holder.view), list[position])
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.view.also {
            it.removeAllViews()
        }
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount() = list.size

    private suspend fun getKeys(l: List<Item>): List<Key> {
        return l.pmap(key)
    }

    fun changeItems(newList: List<Item>) {
        launch {
            val diffUtil = LazyDiffUtil(list, newList, getKeys(list), getKeys(newList))
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            list = newList
            diffResult.dispatchUpdatesTo(this@LazyListAdapter)
        }
    }

    class LazyDiffUtil<Item : Any, Key : Any>(
        private val oldList: List<Item>,
        private val newList: List<Item>,
        private val oldKeys: List<Key>,
        private val newKeys: List<Key>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldKeys[oldItemPosition] == newKeys[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()
}

suspend fun <A, B> Iterable<A>.pmap(f: suspend (A) -> B): List<B> = coroutineScope {
    map { async { f(it) } }.awaitAll()
}