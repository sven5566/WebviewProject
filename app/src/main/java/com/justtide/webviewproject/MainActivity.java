package com.justtide.webviewproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.justtide.webviewproject.util.L;
import com.justtide.webviewproject.view.LoadingDialog;

public class MainActivity extends AppCompatActivity {
	public static final String INTENT_KEY="MainActivity";
	WebView webView;
	LoadingDialog loadingDialog;
	private String urlStr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		webView = findViewById(R.id.main_webview);
		loadingDialog = new LoadingDialog();
		initWebview();
		final String stringExtra = getIntent().getStringExtra(INTENT_KEY);
		if(TextUtils.isEmpty(stringExtra)){
			urlStr="https://www.baidu.com";
		}else{
			urlStr=stringExtra;
		}
		webView.loadUrl(urlStr);
		loadingDialog.show(getFragmentManager());

	}

	private void initWebview() {
		webView.setWebViewClient(new WebViewClient() {
			//覆盖shouldOverrideUrlLoading 方法
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				L.a("加载地址：" + url);
				return true;
			}
		});
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				if (newProgress == 100) {
					// 网页加载完成
					endLoading();
				} else {
					// 加载中
					if (loadingDialog != null && loadingDialog.isAdded()) {
						loadingDialog.setText("页面加载中-" + newProgress + "%\n加载地址："+urlStr);
					}

				}
			}
		});
		webView.getSettings().setJavaScriptEnabled(true);
	}

	private void endLoading() {
		if (loadingDialog != null) {
			loadingDialog.dismiss();
		}
	}
}
