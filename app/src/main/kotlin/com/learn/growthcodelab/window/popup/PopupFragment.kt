package com.learn.growthcodelab.window.popup

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.core.widget.PopupWindowCompat
import android.view.*
import android.widget.PopupWindow
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentPopupBinding
import com.learn.growthcodelab.databinding.PopupWhatBinding
import com.learn.growthcodelab.fragment.BaseFragment

class PopupFragment : BaseFragment(), View.OnClickListener{

    private lateinit var popupNormal: PopupWindow

    companion object {
        fun newInstance() = PopupFragment()
    }

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentPopupBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.onClickListener = this
        return binding.root
    }

    override fun getLayoutRes() = R.layout.fragment_popup

    override fun onClick(view: View?) {
        view?.let {
            when(it.id){
                R.id.btn_window_show_popup -> showNormalPopup()
            }
        }
    }

    private fun showNormalPopup(){
        val viewWhat = View.inflate(activity, R.layout.popup_what, null)
        PopupWhatBinding.bind(viewWhat).setOnClickListener { _ ->  dismissNormalPopup() }
        popupNormal = PopupWindow(viewWhat, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//        popupNormal.isClippingEnabled = false
//        PopupWindowCompat.setWindowLayoutType(popupNormal, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        popupNormal.showAtLocation(view?.rootView, Gravity.NO_GRAVITY, 0, -0)
    }

    private fun dismissNormalPopup(){
        if(popupNormal.isShowing){
            popupNormal.dismiss()
        }
    }


}