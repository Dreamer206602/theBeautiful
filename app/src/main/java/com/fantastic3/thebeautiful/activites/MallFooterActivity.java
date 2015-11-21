package com.fantastic3.thebeautiful.activites;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.config.Cfig;

public class MallFooterActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView mWebView;
    private ProgressBar mProgressBar;
    private TextView tvBack,tvBack2,tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_footer);
        initView();

        initEvent();
    }



    private void initView() {

        mWebView= (WebView) findViewById(R.id.mallFooter_aty_webView);
        mProgressBar= (ProgressBar) findViewById(R.id.mallFooter_aty_seekBar);
        tvBack= (TextView) findViewById(R.id.mallFooter_aty_tv_back);
        tvTitle= (TextView) findViewById(R.id.mallFooter_aty_tv_title);
        tvBack2= (TextView) findViewById(R.id.mallFooter_aty_tv_back2);




        tvBack.setOnClickListener(this);
        tvBack2.setOnClickListener(this);


    }

    /**
     * 初始化事件
     */
    private void initEvent() {

        String footerDetailUrl = getIntent().getStringExtra(Cfig.MALL_FOOTER_LISTERVIEW_DETAIL);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);

        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mProgressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                tvTitle.setText(title);
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {


        });


        mWebView.loadUrl(footerDetailUrl);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.mallFooter_aty_tv_back:
                finish();
            break;

            case R.id.mallFooter_aty_tv_back2:
                finish();
                break;
        }
    }
}
