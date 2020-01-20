package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.notify.PhoneFragment;
import com.learn.growthcodelab.playground.OverdrawFragment;
import com.learn.growthcodelab.view.widget.InputFilterMinMax;
import com.learn.growthcodelab.view.widget.QuantityRangeInputFilter;
import com.learn.growthcodelab.viewshowcase.constraint.AddViewToConstraintFragment;


public class PlayGroundActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, PlayGroundActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
     /*   getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_play_ground_container,
                        PhoneFragment.Companion.newInstance(),
                        "phone")
                .addToBackStack(null)
                .commit();*/

        EditText etQuantityRange = findViewById(R.id.et_quantity_range);
        QuantityRangeInputFilter filter = new QuantityRangeInputFilter();
        InputFilter[] filters = {filter};
        etQuantityRange.setFilters(filters);
    }
}
