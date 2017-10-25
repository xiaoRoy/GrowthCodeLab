package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.learn.growthcodelab.R;


public class WebViewActivity extends BaseActivity implements View.OnClickListener{

    private static final String URL_WWS_PREVIEW = "https://qa-beta.theknot.com/us/mary-jane-and-peter-parker";
    private static final String URL_WWS_REGISTRY = "https://track-registry.theknot.com/track/rqs?a=997&lt=RegistryCreationTool&rt=10855&sp=logo&ss=PlannerGrid&st=RegistryCreation";

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
        findViewById(R.id.btn_web_view_load_registry).setOnClickListener(this);
        initWebView();
    }

    private void initWebView(){
        mWebViewPreview.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                showToast();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                logSslError(error);
            }
        });
        WebSettings webSettings = mWebViewPreview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    private static void logSslError(SslError sslError){
        String sslErrorMsg;
        switch (sslError.getPrimaryError()){
            case SslError.SSL_NOTYETVALID:
                sslErrorMsg = "he certificate is not yet valid";
                break;
            case SslError.SSL_EXPIRED:
                sslErrorMsg = "The certificate has expired";
                break;
            case SslError.SSL_IDMISMATCH:
                sslErrorMsg = "Hostname mismatch";
                break;
            case SslError.SSL_UNTRUSTED:
                sslErrorMsg = "The certificate authority is not trusted";
                break;
            case SslError.SSL_DATE_INVALID:
                sslErrorMsg = "The date of the certificate is invalid";
                break;
            case SslError.SSL_INVALID:
                sslErrorMsg = " A generic error occurred";
                break;
            default:
                sslErrorMsg = "";
                break;
        }
        Log.e("trail", "WebViewActivity.onReceivedSslError:" + sslErrorMsg);
    }

    private void showToast(){
        Toast.makeText(this, R.string.s_web_view_load_finished, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_web_view_start_loading:
                mWebViewPreview.loadUrl(URL_WWS_PREVIEW);
                break;
            case R.id.btn_web_view_load_registry:
                mWebViewPreview.loadUrl(URL_WWS_REGISTRY);
                break;
        }
    }

    private WebViewClient mLoadJsWebViewClient = new WebViewClient(){
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
    };

}
