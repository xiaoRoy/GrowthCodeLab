package com.learn.growthcodelab.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.fragment.BaseFragment;


public class TextInputLayoutFragment extends BaseFragment {

    private View mBtnShowError;
    private TextInputLayout mInputUserName;

    public static TextInputLayoutFragment newInstance(){
        return new TextInputLayoutFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_text_input_layout;
    }


    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        mBtnShowError = rootView.findViewById(R.id.btn_show_error);
        mInputUserName = (TextInputLayout) rootView.findViewById(R.id.layout_user_name);
        mBtnShowError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInputUserName.setError(getString(R.string.s_password_incorrect) );
            }
        });
    }
}
