package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.learn.growthcodelab.R;


public class WebViewActivity extends BaseActivity implements View.OnClickListener{

    private static final String URL_WWS_PREVIEW = "https://qa-beta.theknot.com/us/mary-jane-and-peter-parker";

    private WebView mWebViewPreview;

    public static void start(Context context){
        context.startActivity(new Intent(context, WebViewActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebViewPreview = (WebView)findViewById(R.id.web_view_preview);
        findViewById(R.id.btn_web_view_start_loading).setOnClickListener(this);
        initWebView();
    }

    private void initWebView(){
        mWebViewPreview.setWebViewClient(new WebViewClient(){
            private boolean mIsLoadedRsvp = false;
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    mWebViewPreview.evaluateJavascript("$('span.rsvp-link').click()", null);
                } else {
                    if(!mIsLoadedRsvp){
                        Log.e("trail", "WebViewActivity.onPageFinished.below.KITKAT");
                        mWebViewPreview.loadUrl("javascript:".concat("$('span.rsvp-link').click()"));
                        mIsLoadedRsvp = true;
                    }
                }
            }
        });
        WebSettings webSettings = mWebViewPreview.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_web_view_start_loading:
                mWebViewPreview.loadUrl(URL_WWS_PREVIEW);
                break;
        }
    }
}
