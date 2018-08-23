package com.learn.growthcodelab.playground

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class InsideDialogFragment : BaseFragment() {

    companion object {
        fun newInstance() = InsideDialogFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_dialog

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.let {
            it.findViewById(R.id.btn_dialog_show).setOnClickListener { _ -> showDialog()}
        }
    }

    private fun showDialog(){
        //Base.V7.Theme.AppCompat.Dialog
        val dialog : AlertDialog = AlertDialog
                .Builder(activity)
                .create()
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
    }
}