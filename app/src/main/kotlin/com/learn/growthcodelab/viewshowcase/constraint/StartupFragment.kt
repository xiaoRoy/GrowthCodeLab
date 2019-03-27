package com.learn.growthcodelab.viewshowcase.constraint

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentStartupBinding
import com.learn.growthcodelab.fragment.BaseFragment

class StartupFragment : BaseFragment(), View.OnClickListener{

    companion object {
        fun newInstance() = StartupFragment()
    }

    private lateinit var binding: FragmentStartupBinding

    override fun getLayoutRes(): Int {
        return R.layout.fragment_startup
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        binding.onClickListener = this
        return binding.root
    }

    override fun onClick(view: View) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(context, R.layout.layout_fragment_startup_login)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200
        TransitionManager.beginDelayedTransition(binding.constraintStartup, transition)
        constraintSet.applyTo(binding.constraintStartup)
    }
}