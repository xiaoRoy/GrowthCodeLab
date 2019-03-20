package com.learn.growthcodelab.viewshowcase.constraint

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentConstraintSetBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ConstraintSetFragment : BaseFragment() {

    private lateinit var binding: FragmentConstraintSetBinding

    private val constraintSetCollapsed = ConstraintSet()
    private val constraintSetExpanded = ConstraintSet()
    private var isExpanded = false

    companion object {
        fun newInstance() = ConstraintSetFragment()
        const val DURATION = 1200L

    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_constraint_set
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        return binding.root
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        binding.btnHobbitMore.setOnClickListener { _ -> onMoreClicked() }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constraintSetCollapsed.clone(binding.constraintHobbitRoot)
        constraintSetExpanded.clone(activity, R.layout.fragment_constraint_set_expanded)
    }

    private fun onMoreClicked() {
        val constraintSet = if(isExpanded) {
            constraintSetCollapsed
        } else {
            constraintSetExpanded
        }
        val transitionFade = Fade()
        val transitionChangeBounds = ChangeBounds()
        val transitions = TransitionSet()
        transitions.addTransition(transitionFade)
        transitions.addTransition(transitionChangeBounds)
        transitions.interpolator = AnticipateInterpolator(1.0f);
        transitions.duration = DURATION
        constraintSet.applyTo(binding.constraintHobbitRoot)
        isExpanded = !isExpanded
        TransitionManager.beginDelayedTransition(binding.constraintHobbitRoot, transitions)

    }
}