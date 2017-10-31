package com.learn.growthcodelab.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.recycler.SuspensionItemDecoration;
import com.learn.growthcodelab.recycler.TextAdapter;

public class RecyclerActivity extends BaseActivity {

    private RecyclerView mRecyclerText;

    private TextAdapter mTextAdapter;

    public static void start(Context context){
        context.startActivity(new Intent(context, RecyclerActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecyclerText = (RecyclerView) findViewById(R.id.recycler_text);
        mTextAdapter = new TextAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerText.setLayoutManager(layoutManager);
        SuspensionItemDecoration suspensionItemDecoration = new SuspensionItemDecoration();
        mRecyclerText.addItemDecoration(suspensionItemDecoration);
        mRecyclerText.setAdapter(mTextAdapter);
    }
}
