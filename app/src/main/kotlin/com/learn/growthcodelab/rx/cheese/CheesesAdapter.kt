package com.learn.growthcodelab.rx.cheese

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learn.growthcodelab.R
import com.learn.growthcodelab.recycler.BaseDataBindingAdapter
import com.learn.growthcodelab.recycler.DataBindingViewHolder
import com.learn.growthcodelab.view.CheckableImageView
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class CheesesAdapter : BaseDataBindingAdapter() {

    private val cheeseList = mutableListOf<Cheese>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        return super.onCreateViewHolder(parent, viewType).apply {
            Observable.create<Boolean> { emitter ->
                val ivCheeseFavorite = this.binding.root.findViewById<CheckableImageView>(R.id.iv_cheese_favorite)
                emitter.setCancellable { ivCheeseFavorite.setOnClickListener(null) }
                ivCheeseFavorite.setOnClickListener {
                    emitter.onNext(ivCheeseFavorite.isChecked)
                }
            }.toFlowable(BackpressureStrategy.LATEST)
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        cheeseList[adapterPosition].hasFavorite = it
                    }.also { compositeDisposable.add(it) }
        }
    }

    override fun getItemByPosition(position: Int): Any = cheeseList[position]

    override fun getLayoutIdByPosition(position: Int): Int = R.layout.item_cheese

    override fun getItemCount(): Int = cheeseList.size

    fun updateCheese(cheeses: List<Cheese>) {

        cheeseList.clear()
        cheeseList.addAll(cheeses)
        notifyDataSetChanged()
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        compositeDisposable.clear()
    }
}