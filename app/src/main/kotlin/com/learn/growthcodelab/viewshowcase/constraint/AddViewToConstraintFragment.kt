package com.learn.growthcodelab.viewshowcase.constraint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentAddViewToConstraintBinding
import com.learn.growthcodelab.fragment.BaseFragment

class AddViewToConstraintFragment : BaseFragment(){

    companion object {
        fun newInstance() = AddViewToConstraintFragment()
    }

    private lateinit var binding: FragmentAddViewToConstraintBinding

    override fun getLayoutRes(): Int {
        return R.layout.fragment_add_view_to_constraint
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        return binding.root
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        addViewByLayoutParams(inflater)
        return root
    }

    private fun addViewByConstraintSet(inflater: LayoutInflater) {
        val constraintSet = ConstraintSet()
        val viewToAdd = inflater.inflate(R.layout.layout_constraint_constent, binding.constraintAddView, false)
        binding.constraintAddView.addView(viewToAdd)
        constraintSet.clone(binding.constraintAddView)
        constraintSet.connect(R.id.fl_constraint_view_to_add, ConstraintSet.TOP, R.id.tv_constraint, ConstraintSet.BOTTOM)
        constraintSet.connect(R.id.fl_constraint_view_to_add, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(R.id.fl_constraint_view_to_add, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        constraintSet.applyTo(binding.constraintAddView)
    }

    private fun addViewByLayoutParams(inflater: LayoutInflater) {
        val viewToAdd = inflater.inflate(R.layout.layout_constraint_constent, binding.constraintAddView, false)
        val layoutParams = viewToAdd.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.startToStart = binding.constraintAddView.id
        layoutParams.endToEnd = binding.constraintAddView.id
        layoutParams.topToBottom = R.id.tv_constraint
        binding.constraintAddView.addView(viewToAdd, layoutParams)
    }

}