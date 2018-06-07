package com.worktoolslleida.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        Intent intent = getIntent();
        String path = intent.getStringExtra(MainActivity.PDF_PATH);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView
                .fromAsset(path)
                .load();
    }
}
