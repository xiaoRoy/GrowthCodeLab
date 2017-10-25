package com.learn.growthcodelab.widget;

import android.text.Editable;
import android.util.Log;
import android.widget.EditText;

import java.lang.ref.WeakReference;

public class PhoneNumberTextWatcher extends SimpleTextWatcher {

    private static final String HYPHEN = "\u002d";

    final private WeakReference<EditText> mRefEtPhoneNumber;

    private boolean mIsInputting;

    private PhoneNumberChangeCallback mPhoneNumberChangeCallback;

    public PhoneNumberTextWatcher(EditText etPhoneNumber) {
        mRefEtPhoneNumber = new WeakReference<>(etPhoneNumber);
    }

    /*
    * 从start开始的count个字符替换长度为before的旧字符
    * count abc -> ab replace 'c' with '', so the count is 0
    * count abc -> abcd replace '' with 'd', so the count is 1
     * */
    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        Log.e("trail", "PhoneNumberTextWatcher.onTextChanged.charSequence:" + charSequence);
        Log.e("trail", "PhoneNumberTextWatcher.onTextChanged.start:" + start);
        Log.e("trail", "PhoneNumberTextWatcher.onTextChanged.before:" + before);
        Log.e("trail", "PhoneNumberTextWatcher.onTextChanged.count:" + count);
        mIsInputting = before == 0 && count == 1;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (mRefEtPhoneNumber.get() != null && mIsInputting) {
            int length = editable.length();
            EditText etPhoneNumber = mRefEtPhoneNumber.get();
            StringBuilder stringBuilder = new StringBuilder(editable);
            switch (length) {
                case 3:
                case 7:
                    stringBuilder.append(HYPHEN);
                    processHyphen(stringBuilder, etPhoneNumber);
                    break;
                case 4:
                case 8:
                    stringBuilder.insert(length - 1, HYPHEN);
                    processHyphen(stringBuilder, etPhoneNumber);
                    break;
            }

        }
        if(mPhoneNumberChangeCallback != null){
            mPhoneNumberChangeCallback.onPhoneNumberChanged(editable);
        }
    }

    public void setPhoneNumberChangeCallback(PhoneNumberChangeCallback phoneNumberChangeCallback) {
        mPhoneNumberChangeCallback = phoneNumberChangeCallback;
    }

    private static void processHyphen(StringBuilder stringBuilder, EditText etPhoneNumber) {
        String result = stringBuilder.toString();
        etPhoneNumber.setText(result);
        etPhoneNumber.setSelection(result.length());
    }

    public interface PhoneNumberChangeCallback{
        void onPhoneNumberChanged(Editable editable);
    }

}
