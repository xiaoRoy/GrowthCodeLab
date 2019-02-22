package com.learn.growthcodelab.viewshowcase

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentSpanBinding
import com.learn.growthcodelab.fragment.BaseFragment
import org.wordpress.aztec.Aztec
import org.wordpress.aztec.ITextFormat
import org.wordpress.aztec.toolbar.IAztecToolbarClickListener

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
        Aztec.with(binding.visual, binding.formattingToolbar, object : IAztecToolbarClickListener{
            override fun onToolbarCollapseButtonClicked() {
            }

            override fun onToolbarExpandButtonClicked() {
            }

            override fun onToolbarFormatButtonClicked(format: ITextFormat, isKeyboardShortcut: Boolean) {
            }

            override fun onToolbarHeadingButtonClicked() {
            }

            override fun onToolbarHtmlButtonClicked() {
            }

            override fun onToolbarListButtonClicked() {
            }

            override fun onToolbarMediaButtonClicked(): Boolean {
                return true
            }
        })
        val editableText = binding.etSpanByFormatSpan.editableText
        if(editableText.isEmpty()) {
            /*val result = SpannableStringBuilder(editableText).append("", StyleSpan(Typeface.BOLD), Spanned.SPAN_POINT_POINT)
            binding.etSpanByFormatSpan.setText(result, TextView.BufferType.EDITABLE)*/
            editableText.setSpan(StyleSpan(Typeface.BOLD), 0, 0, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        }
        hasSpan()
    }

    private fun hasSpan() {
        val result = binding.etSpanByFormatSpan.editableText.getSpans(0, 0, StyleSpan::class.java) != null
        Log.d("Span", "hasSpan:$result")
    }
}