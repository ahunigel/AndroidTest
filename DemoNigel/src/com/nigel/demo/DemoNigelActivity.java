package com.nigel.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DemoNigelActivity extends Activity {
    /** Called when the activity is first created. */
    WebView mWebView;
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mWebView = (WebView) findViewById(R.id.webView1); 
        mWebView.getSettings().setJavaScriptEnabled(true); 
        
     	// OR, you can also load from an HTML string: 
        String summary = "<html><body>"
        		+"<title>Nigeland</title><meta http-equiv='refresh' content='10;URL=http://www.baidu.com'>"
        		+" <a href='http://www.baidu.com/'>Baidu</a> <a href='http://www.google.com/'>Google</a>"
        		+" <a href='http://www.51job.com/' title='招聘，找工作求职，上前程无忧'>前程无忧</a>"
        		+" <a href='http://www.zhaopin.com/' title='招聘 求职 智联招聘首页'>智联招聘</a>"
        		+" <a href='http://www.chinahr.com/' title='找工作 人才招聘｜中华英才网 Chinahr.com'>中华英才</a>"
        		+" <a href='http://www.myjob.edu.cn/' title='中国高校毕业生就业服务信息网'>毕就业网</a>"
        		+" <a href='http://www.chinagwy.org/' title='国家公务员考试网-国家公务员考试最新资讯-报名时间发布'>国家公务员网</a>"
        		+" <a href='http://www.ceiaec.org/'>IT考试</a>"
        		+"<p><br>10秒钟后自动转向baidu.com</p></body></html>"; 
        mWebView.loadData(summary, "text/html", null); 
        // ... although note that there are restrictions on what this HTML can do. 
        // See the JavaDocs for loadData() and loadDataWithBaseURL() for more info.

        //mWebView.loadUrl("http://www.baidu.com"); 
        
        mWebView.setWebViewClient(new HelloWebViewClient());
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) { 
            mWebView.goBack(); 
            return true; 
        } 
        return super.onKeyDown(keyCode, event); 
    }

    private class HelloWebViewClient extends WebViewClient { 
        @Override 
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    }
    
}



/*        Uri uri = Uri.parse("http://www.baidu.com"); 
Intent intent = new Intent(Intent.ACTION_VIEW, uri); 
startActivity(intent); */
/*        WebView webview = new WebView(this); 
setContentView(webview); */
// Simplest usage: note that an exception will NOT be thrown 
// if there is an error loading this page (see below). 
//webview.loadUrl("http://www.baidu.com/"); 

// OR, you can also load from an HTML string: 
/*        String summary = "<html><body>You scored <b>192</b> points.</body></html>"; 
webview.loadData(summary, "text/html", null); */
// ... although note that there are restrictions on what this HTML can do. 
// See the JavaDocs for loadData() and loadDataWithBaseURL() for more info.
