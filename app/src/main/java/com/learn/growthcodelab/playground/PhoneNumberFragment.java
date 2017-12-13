package com.learn.growthcodelab.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.fragment.BaseFragment;
import com.learn.growthcodelab.widget.PhoneNumberTextWatcher;


public class PhoneNumberFragment extends BaseFragment {

    private EditText mEtPhoneNumber;

    public static PhoneNumberFragment newInstance(){
        return new PhoneNumberFragment();
    }

    public PhoneNumberFragment(){

    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_phone_number;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEtPhoneNumber = (EditText) view.findViewById(R.id.et_phone_number);
        PhoneNumberTextWatcher phoneNumberTextWatcher = new PhoneNumberTextWatcher(mEtPhoneNumber);
        mEtPhoneNumber.addTextChangedListener(phoneNumberTextWatcher);
        mEtPhoneNumber.setText("123-564-");
    }
}
