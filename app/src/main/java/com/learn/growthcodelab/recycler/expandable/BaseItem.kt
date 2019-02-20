package com.learn.growthcodelab.recycler.expandable

import androidx.annotation.LayoutRes
import android.view.View
import java.util.concurrent.atomic.AtomicLong


/*
* BaseItem is a group only contains one item.
* */
abstract class BaseItem<VH: BaseViewHolder> constructor(val id: Long): BaseGroup {

    private companion object {
        val idCounter = AtomicLong(0)

        const val INDIVIDUAL_POSITION = 0
    }

    protected var groupDataObserver: GroupDataObserver? = null

    constructor(): this(idCounter.decrementAndGet())

    fun createViewHolder(itemView: View):VH{
        return BaseViewHolder(itemView) as VH
    }

    override fun getItemCount() = 1

    override fun getItem(position: Int): BaseItem<*> {
         if(position == INDIVIDUAL_POSITION) {
             return this
         } else {
             throw IndexOutOfBoundsException()
         }
    }

    override fun getItemPosition(item: BaseItem<*>) = if(item === this) INDIVIDUAL_POSITION else -1

    override fun registerGroupDataObserver(groupDataObserver: GroupDataObserver) {
        this.groupDataObserver = groupDataObserver
    }

    override fun unregisterGroupDataObserver(groupDataObserver: GroupDataObserver) {
        this.groupDataObserver = null
    }

    abstract fun bind(viewHolder: BaseViewHolder, position: Int)

    fun bind(viewHolder: BaseViewHolder, position: Int, payloads: List<Any>){
        viewHolder.bind(this)
        bind(viewHolder, position)
    }

    fun unbind(viewHolder: BaseViewHolder){
        viewHolder.unbind()
    }

    fun notifyChanged(payload: Any? = null){
        groupDataObserver?.onItemChanged(this, INDIVIDUAL_POSITION, payload)
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    fun isSameAs(another: BaseItem<*>): Boolean{
        if(getLayoutRes() != another.getLayoutRes()){
            return false
        }
        return id == another.id
    }
}