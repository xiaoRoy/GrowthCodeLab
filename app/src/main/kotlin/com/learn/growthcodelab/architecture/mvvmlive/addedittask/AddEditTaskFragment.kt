package com.learn.growthcodelab.architecture.mvvmlive.addedittask

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.DataBinderMapperImpl
import androidx.lifecycle.Observer
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentAddEditTaskBinding
import com.learn.growthcodelab.fragment.BaseFragment

class AddEditTaskFragment : BaseFragment() {

    companion object {
        fun newInstance() = AddEditTaskFragment()
    }

    private lateinit var viewModel: AddEditTaskViewModel
    private lateinit var navigator: AddEditTaskNavigator
    private lateinit var binding: FragmentAddEditTaskBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = if (context is AddEditTaskNavigator) context
        else throw IllegalAccessException()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_add_edit_task
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.setLifecycleOwner(this.viewLifecycleOwner)
        viewModel = navigator.obtainAddEditTaskViewModel()
        viewModel.message.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
            }
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}