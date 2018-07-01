package com.learn.growthcodelab.playground

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R

class NotFullDialogFragment : DialogFragment(){

    companion object {
        fun newInstance() = NotFullDialogFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_not_full_dialog, container, false)
    }
}