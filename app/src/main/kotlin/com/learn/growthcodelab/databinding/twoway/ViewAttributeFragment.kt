package com.learn.growthcodelab.databinding.twoway

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentViewAttributeBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ViewAttributeFragment : BaseFragment() , ShowLogCallback{

    companion object {
        fun newInstance() = ViewAttributeFragment()
    }

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentViewAttributeBinding? = inflater?.inflate(layoutRes, container, false)?.let { FragmentViewAttributeBinding.bind(it) }
        //Automatic conversion of lambdas to objects implementing Kotlin interfaces isn't sup- ported.
        //val showLogCallback: ShowLogCallback  = {view: View, log: String -> print("")}
        binding?.showLogCallback = this
        return binding?.root
    }

    override fun getLayoutRes() = R.layout.fragment_view_attribute

    override fun onShowLogClicked(view: View, log: String) {
        Log.i("ViewAttributeFragment", log)
    }

    override fun onShowLogClicked(targetView: TextView) {
        Log.i("ViewAttributeFragment", targetView.text.toString())
    }
}