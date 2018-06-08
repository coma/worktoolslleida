package com.worktoolslleida.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;

public class PDFActivity extends AppCompatActivity implements OnPageErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        Intent intent = getIntent();
        String path = intent.getStringExtra(MainActivity.PDF_PATH);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView
                .fromAsset(path)
                .onPageError(this)
                .load();
    }

    @Override
    public void onPageError(int page, Throwable error) {
        String message = "Vaya, he tenido un problema con ese pdf...";
        Context context = getApplicationContext();

        Toast
                .makeText(context, message, Toast.LENGTH_SHORT)
                .show();

        finish();
    }
}
