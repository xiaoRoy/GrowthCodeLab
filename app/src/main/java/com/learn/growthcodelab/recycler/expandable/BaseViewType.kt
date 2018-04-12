package com.learn.growthcodelab.recycler.expandable

abstract class BaseViewType<VH:BaseViewHolder> : BaseGroup {

    override fun getItemCount() = 1

    override fun getViewType(position: Int): BaseViewType<*> {
         if(position == 0) {
             return this
         } else {
             throw IndexOutOfBoundsException()
         }
    }

    override fun getPosition(viewType: BaseViewType<*>) = if(viewType === this) 0 else -1
}