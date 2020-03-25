package com.learn.growthcodelab.view;


import android.widget.CompoundButton;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

//@InverseBindingMethods({@InverseBindingMethod(type = TopChoiceLayout.class, attribute = "topChoice")})
//public class TestBindingAdapters {
//
//    @InverseBindingAdapter(attribute = "topChoice", event = "topChoiceAttrChanged")
//    public static boolean isTopChoice(TopChoiceLayout topChoiceLayout) {
//        return topChoiceLayout.isTopChoice();
//    }
//
//    @BindingAdapter("topChoice")
//    public static void setTopChoice(TopChoiceLayout topChoiceLayout, boolean topChoice) {
//        topChoiceLayout.setTopChoice(topChoice);
//    }
//
//    @BindingAdapter(value = {"topChoiceAttrChanged", "onTopChoiceChangedListener"}, requireAll = false)
//    public static void setOnTopChoiceChangedListener(TopChoiceLayout topChoiceLayout, InverseBindingListener inverseBindingListener, CompoundButton.OnCheckedChangeListener onTopChoiceChangedListener) {
//        if (inverseBindingListener != null) {
//            topChoiceLayout.setOnTopChoiceChangedListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    inverseBindingListener.onChange();
//                }
//            });
//        }
//    }
//}
