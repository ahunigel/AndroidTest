package com.hello.tabwidget;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class SongsActivity extends Activity { 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
 
        TextView textview = new TextView(this); 
        textview.setText("This is the Songs tab"); 
        setContentView(textview); 
        WebView webview = new WebView(this); 
        setContentView(webview); 
        webview.loadUrl("http://www.baidu.com/"); 
    } 
}