package com.example.applicationflatmap.Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.applicationflatmap.R;

public class UploadFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);
    }

    public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }
    // Stop the service
    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }
}
