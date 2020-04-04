package com.learn.growthcodelab.recycler.group

import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.growthcodelab.recycler.DataBindingViewHolder

class GroupAdapter : RecyclerView.Adapter<DataBindingViewHolder>(), GroupObserver {

    val groups = mutableListOf<ExpandableGroup>()

    private var lastFoundViewType: BaseViewType? = null

    var spanCount = 1

    val spanSizeLookup: GridLayoutManager.SpanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return try {
                findViewTypeByPosition(position).getSpanCount(spanCount, position)
            } catch (exception: IndexOutOfBoundsException) {
                spanCount
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        val itemViewType = findViewType(viewType)
        return itemViewType.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return groups.sumBy { it.getItemCount() }
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        findViewTypeByPosition(position).onBindViewHolder(holder, position)
    }

    private fun findViewTypeByPosition(position: Int): BaseViewType {
        var tempPosition = 0
        for (group in groups) {
            val groupSize = group.getItemCount()
            if (groupSize + tempPosition > position) {
                return group.getViewType(position - tempPosition)
            } else {
                tempPosition += groupSize
            }
        }
        throw IndexOutOfBoundsException("view type not found!")
    }

    private fun findViewType(layoutRes: Int): BaseViewType {
        val targetViewType = lastFoundViewType
        if (targetViewType != null && targetViewType.getLayoutResource() == layoutRes) {
            return targetViewType
        }
        for (position in 0 until itemCount) {
            val viewType = findViewType(position)
            if (viewType.getLayoutResource() == layoutRes) {
                return viewType
            }
        }
        throw IndexOutOfBoundsException("view type not found!")
    }


    override fun getItemViewType(position: Int): Int {
        val viewType = findViewTypeByPosition(position)
        lastFoundViewType = viewType
        return viewType.getLayoutResource()
    }

    override fun onChanged(group: BaseGroup) {
    }

    override fun onItemRangeRemoved(group: BaseGroup, startPosition: Int, itemCount: Int) {
    }

    override fun onItemRangeInserted(group: BaseGroup, startPosition: Int, itemCount: Int) {
    }
}