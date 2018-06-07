package com.worktoolslleida.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    public static final String PDF_PATH = "com.worktoolslleida.app.PDF_PATH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView view = findViewById(R.id.webView);
        view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.endsWith(".pdf")) {
                    openPDF(url);
                } else {
                    view.loadUrl(url);
                }

                return false;
            }
        });

        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("file:android_asset/index.html");
    }

    private void openPDF(String url) {
        String path = url.substring(22);
        Intent intent = new Intent(this, PDFActivity.class);
        intent.putExtra(PDF_PATH, path);
        startActivity(intent);
    }
}
