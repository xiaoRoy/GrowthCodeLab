package com.learn.growthcodelab.viewshowcase

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.commonsware.cwac.richedit.RichEditText
import com.commonsware.cwac.richedit.StyleEffect
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentSpanBinding
import com.learn.growthcodelab.fragment.BaseFragment

class SpanFragment : BaseFragment() {


    companion object {
        fun newInstance() = SpanFragment()
    }

    private lateinit var binding: FragmentSpanBinding

    override fun getLayoutRes(): Int {
        return R.layout.fragment_span
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editableText = binding.etSpanByFormatSpan.editableText
       /* if(editableText.isEmpty()) {
            val result = SpannableStringBuilder(editableText).append("", StyleSpan(Typeface.BOLD), Spanned.SPAN_POINT_POINT)
            binding.etSpanByFormatSpan.setText(result, TextView.BufferType.EDITABLE)
            *//*editableText.setSpan(StyleSpan(Typeface.BOLD), 0, 0, Spanned.SPAN_POINT_POINT)*//*
        }*/
    }
}