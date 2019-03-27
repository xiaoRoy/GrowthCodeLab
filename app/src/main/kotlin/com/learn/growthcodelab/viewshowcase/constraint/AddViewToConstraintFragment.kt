package com.learn.growthcodelab.viewshowcase.constraint

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentAddViewToConstraintBinding
import com.learn.growthcodelab.fragment.BaseFragment

class AddViewToConstraintFragment : BaseFragment(), View.OnClickListener{

    companion object {
        fun newInstance() = AddViewToConstraintFragment()
    }

    private lateinit var binding: FragmentAddViewToConstraintBinding

    override fun getLayoutRes(): Int {
        return R.layout.fragment_add_view_to_constraint
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        binding.onClickListener = this
        return binding.root
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        return root
    }

    private fun addViewByConstraintSet() {
        removeTheAddedView()
        val constraintSet = ConstraintSet()
        val viewToAdd = LayoutInflater.from(context).inflate(R.layout.layout_constraint_constent, binding.constraintAddView, false)
        binding.constraintAddView.addView(viewToAdd)
        constraintSet.apply {
            clone(binding.constraintAddView)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.TOP, R.id.tv_constraint, ConstraintSet.BOTTOM)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            constrainWidth(R.id.fl_constraint_view_to_add, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(R.id.fl_constraint_view_to_add, ConstraintSet.MATCH_CONSTRAINT)
            applyTo(binding.constraintAddView)
        }
    }

    private fun removeTheAddedView() {
        val addedView = binding.constraintAddView.findViewById<View>(R.id.fl_constraint_view_to_add)
        if(addedView != null) {
            binding.constraintAddView.removeView(addedView)
        }
    }

    private fun addViewByConstraintSetUsingGuideLine() {
        removeTheAddedView()
        val constraintSet = ConstraintSet()
        val viewToAdd = LayoutInflater.from(context).inflate(R.layout.layout_constraint_constent, binding.constraintAddView, false)
        binding.constraintAddView.addView(viewToAdd)
        constraintSet.apply {
            clone(binding.constraintAddView)
            create(R.id.guide_line_add_view_to_constraint, ConstraintSet.HORIZONTAL)
            setGuidelinePercent(R.id.guide_line_add_view_to_constraint, 0.5f)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.TOP, R.id.guide_line_add_view_to_constraint, ConstraintSet.BOTTOM)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(R.id.fl_constraint_view_to_add, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            constrainWidth(R.id.fl_constraint_view_to_add, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(R.id.fl_constraint_view_to_add, ConstraintSet.MATCH_CONSTRAINT)
            applyTo(binding.constraintAddView)
        }
    }

    private fun addViewByLayoutParams() {
        removeTheAddedView()
        val viewToAdd = LayoutInflater.from(context).inflate(R.layout.layout_constraint_constent, binding.constraintAddView, false)
        val layoutParams = viewToAdd.layoutParams as ConstraintLayout.LayoutParams
        val parentId = binding.constraintAddView.id
        layoutParams.apply {
            startToStart = parentId
            endToEnd = parentId
            topToBottom = R.id.tv_constraint
            bottomToBottom = parentId
            guideBegin
            width = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            height = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
        }
        binding.constraintAddView.addView(viewToAdd, layoutParams)
    }

    private fun addViewByLayoutParamUsingGuideLine() {
        removeTheAddedView()
        val viewToAdd = LayoutInflater.from(context).inflate(R.layout.layout_constraint_constent, binding.constraintAddView, false)
        val layoutParams = viewToAdd.layoutParams as ConstraintLayout.LayoutParams
        val parentId = binding.constraintAddView.id
        val guideline = Guideline(binding.constraintAddView.context)
        val guidelineParams =  ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        val guidelineId = View.generateViewId()
        guidelineParams.orientation = ConstraintLayout.LayoutParams.HORIZONTAL
        guideline.layoutParams = guidelineParams
        guideline.setGuidelinePercent(0.5f)
        guideline.id = guidelineId
        binding.constraintAddView.addView(guideline, guidelineParams)
        layoutParams.apply {
            startToStart = parentId
            endToEnd = parentId
            topToBottom = guidelineId
            bottomToBottom = parentId
            guideBegin
            width = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            height = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
        }

        TransitionManager.beginDelayedTransition(binding.constraintAddView)
        binding.constraintAddView.addView(viewToAdd, layoutParams)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btn_constraint_first -> addViewByConstraintSet()
            R.id.btn_constraint_second -> addViewByConstraintSetUsingGuideLine()
            R.id.btn_constraint_third -> addViewByLayoutParams()
            R.id.btn_constraint_fourth -> addViewByLayoutParamUsingGuideLine()
        }
    }
}