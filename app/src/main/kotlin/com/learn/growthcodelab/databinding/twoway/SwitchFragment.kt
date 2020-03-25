package com.learn.growthcodelab.databinding.twoway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.learn.growthcodelab.BR
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentSwitchBinding
import com.learn.growthcodelab.fragment.BaseFragment

class SwitchFragment : BaseFragment() {

    private lateinit var binding: FragmentSwitchBinding

    private lateinit var viewModel: SwitchViewModel


    override fun getLayoutRes(): Int {
        return R.layout.fragment_switch
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        viewModel = SwitchViewModel(preventFirstTime {
            val message = if (it) "What is it about?" else "Why@@!"
            Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
        })

        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.isTopChoice = true
    }

    companion object {
        @JvmStatic
        fun newInstance() = SwitchFragment()
    }

    private fun <T> preventFirstTime(operation: (T) -> Unit): (T) -> Unit {
        var firstTime = true
        return { t ->
            if (!firstTime) {
                operation(t)
            }
            firstTime = false
            println("trial.preventFirstTime")
        }

    }
}


class SwitchViewModel(private val callback: (Boolean) -> Unit) : BaseObservable() {

    @Bindable
    var isTopChoice = false
        set(value) {
            println("trail.isTopChoice:$value")
            field = value
            notifyPropertyChanged(BR.topChoice)
            callback(value)
        }
}

