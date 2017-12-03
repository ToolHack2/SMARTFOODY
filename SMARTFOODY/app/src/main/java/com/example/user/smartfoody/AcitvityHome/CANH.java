package com.example.user.smartfoody.AcitvityHome;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.smartfoody.R;

import com.example.user.smartfoody.View.ViewVideo;
import com.google.zxing.Result;


import me.dm7.barcodescanner.zxing.ZXingScannerView;




/**
 * Created by User on 11/27/2017.
 */

public class CANH extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    BottomNavigationView home;
    private ZXingScannerView scannerView;

    SurfaceView view;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canh_activity);

        home = (BottomNavigationView)findViewById(R.id.menucanh);
        view = (SurfaceView)findViewById(R.id.qrview);
        scan(view);

    }
    public void scan(View view)
    {
        scannerView = new ZXingScannerView(getApplicationContext());
        setContentView(scannerView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_SHORT).show();
        String value = result.getText();
        Intent toview = new Intent(CANH.this, ViewVideo.class);
        toview.putExtra("value", value);
        startActivity(toview);
        scannerView.resumeCameraPreview(this);

    }
}
