package com.nctu.nctuplus.nctuplus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class WebActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView =(WebView)findViewById(R.id.web);
        webView.loadUrl("https://plus.nctu.edu.tw/courses/");
    }

}
