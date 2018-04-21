package com.learn.growthcodelab.recycler.expandable

import android.support.annotation.LayoutRes
import android.view.View
import java.util.concurrent.atomic.AtomicLong

abstract class BaseItem<VH: BaseViewHolder> constructor(val id: Long): BaseGroup {

    private companion object {
        val idCounter = AtomicLong(0)
    }

    protected var groupDataObserver: GroupDataObserver? = null

    constructor(): this(idCounter.decrementAndGet())

    fun createViewHolder(itemView: View):VH{
        return BaseViewHolder(itemView) as VH
    }

    override fun getItemCount() = 1

    override fun getItem(position: Int): BaseItem<*> {
         if(position == 0) {
             return this
         } else {
             throw IndexOutOfBoundsException()
         }
    }

    override fun getItemPosition(item: BaseItem<*>) = if(item === this) 0 else -1

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
        groupDataObserver?.onItemChanged(this, 0, payload)
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