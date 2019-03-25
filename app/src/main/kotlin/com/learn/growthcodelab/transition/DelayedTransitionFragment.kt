package com.learn.growthcodelab.transition

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentDelayedTransitionBinding
import com.learn.growthcodelab.fragment.BaseFragment

class DelayedTransitionFragment : BaseFragment(), DelayedTransitionViewModel.OnDelayedTransitionClickListener {

    companion object {
        fun newInstance() = DelayedTransitionFragment()
    }

    private lateinit var binding: FragmentDelayedTransitionBinding

    private val viewModel = DelayedTransitionViewModel()

    private var isCircleSizeChanged: Boolean = false
    private var circleSavedSize = 0

    override fun getLayoutRes() = R.layout.fragment_delayed_transition

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        inflater.let {
            binding = FragmentDelayedTransitionBinding.bind(it.inflate(layoutRes, container, false))
            binding.onDelayedTransitionClickListener = this
            binding.viewModel = viewModel
        }
        return binding.root
    }

    override fun onChangSizeClicked() {
        TransitionManager.beginDelayedTransition(binding.layoutDelayedTransitionContainer)
        val layoutParams = binding.ivTransitionCircle.layoutParams
        if(isCircleSizeChanged){
            layoutParams.width = circleSavedSize
            layoutParams.height = circleSavedSize
        } else {
            circleSavedSize = layoutParams.width
            val circleLargeSize = resources.getDimensionPixelOffset(R.dimen.circle_larger_size)
            layoutParams.width = circleLargeSize
            layoutParams.height = circleLargeSize
        }
        isCircleSizeChanged = !isCircleSizeChanged
        binding.ivTransitionCircle.layoutParams = layoutParams
    }

    override fun onChangeVisibilityClicked() {
        TransitionManager.beginDelayedTransition(binding.layoutDelayedTransitionContainer)
        viewModel.isCircleVisible.set(!viewModel.isCircleVisible.get())
    }
}