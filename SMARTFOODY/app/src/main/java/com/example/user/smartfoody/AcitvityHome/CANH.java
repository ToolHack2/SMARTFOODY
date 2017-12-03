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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.smartfoody.R;

import com.example.user.smartfoody.View.ViewVideo;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


/**
 * Created by User on 11/27/2017.
 */

public class CANH extends AppCompatActivity {

    BottomNavigationView home;


    Button scan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canh_activity);

        home = (BottomNavigationView)findViewById(R.id.menucanh);
        scan = (Button)findViewById(R.id.btnscan);
        final Activity activity = this;
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Please scan QR code to view more");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null)
        {
            if (result.getContents() == null)
            {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
            else {
                String value = result.getContents();
                Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
                Intent toview = new Intent(CANH.this, ViewVideo.class);
                //toview.putExtra("value", value);
                startActivity(toview);
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
