package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentItemLifecycleBinding
import com.learn.growthcodelab.fragment.BaseFragment

class LifeCycleInViewPageItemFragment : BaseFragment() {

    private lateinit var likeItem: LikeItem

    lateinit var callback: LikeItemLifeCycleCallback

    private lateinit var viewModel: LifeCycleInViewPageItemViewModel

    override fun getLayoutRes() = R.layout.fragment_item_lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*if(arguments != null) {
            likeItem = arguments.getParcelable(BUNDLE_KEY_LIKE) as LikeItem
        }*/

        if(arguments != null) {
            val likeItem = arguments.getParcelable(BUNDLE_KEY_LIKE) as? LikeItem
            if(likeItem != null) {
                this.likeItem = likeItem
            }
        }
        /*likeItem = arguments?.let { bundle:Bundle ->
            bundle.getParcelable(BUNDLE_KEY_LIKE) as? LikeItem
        }*/
    }

    override fun enableLifeCycleLog() = true

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("trail", "onActivityCreated.index:${likeItem.index}")
    }

    fun showTip(isTipVisible: Boolean) {
        viewModel.isTipVisible.set(isTipVisible)
    }

    fun updateLikeAmount() {
        likeItem.amount ++
        viewModel.likeAmount = likeItem.amount
    }


    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentItemLifecycleBinding>(inflater, layoutRes, container, false)
        viewModel = LifeCycleInViewPageItemViewModel(likeItem)
        binding.viewModel = viewModel
        return binding.root
    }

    companion object {
        private const val BUNDLE_KEY_LIKE = "bundle_key_like"

        fun newInstance(likeItem: LikeItem): LifeCycleInViewPageItemFragment{
            val fragment = LifeCycleInViewPageItemFragment()
            val args = Bundle()
            args.putParcelable(BUNDLE_KEY_LIKE, likeItem)
            fragment.arguments = args
            return fragment
        }
    }
}
