package com.learn.growthcodelab.fragment.state

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.BR
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentSectionABinding
import com.learn.growthcodelab.fragment.BaseFragment

class SectionAFragment : BaseFragment(), SectionAContract.ViewRenderer {

    companion object {
        fun newInstance() = SectionAFragment()
    }

    private lateinit var binding: FragmentSectionABinding

    private lateinit var viewModel: SectionAViewModel

    override fun getLayoutRes() = R.layout.fragment_section_a

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewModel = SectionAViewModel()
        binding.viewModel = viewModel
        return binding.root
    }

    override fun enableLifeCycleLog(): Boolean {
        return false
    }

    override fun displaySectionA(result: String) {
        viewModel.result = result
    }

    class SectionAViewModel : BaseObservable() {

        @get:Bindable
        var result: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.result)
        }
    }
}