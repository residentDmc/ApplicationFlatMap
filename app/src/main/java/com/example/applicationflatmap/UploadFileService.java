package com.example.applicationflatmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationflatmap.MapFlap.MainActivity;
import com.example.applicationflatmap.Service.MyService;

import java.io.File;

public class UploadFileService extends AppCompatActivity {

    private TextView textView;
    private String url="/storage/2E93-17F2/kotlin/#10 Kotlin Tutorial - String Template.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file_serive);
        textView = findViewById(R.id.textView);
        File file=new File(url);
        if (file.exists())
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter("my.own.broadcast");
        LocalBroadcastManager.getInstance(this).registerReceiver(myLocalBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myLocalBroadcastReceiver);
    }

    private BroadcastReceiver myLocalBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            String result = intent.getStringExtra("result");
            textView.setText(result);
        }
    };


    public void startService(View view) {
        Intent mIntent = new Intent(this, BackgroundService.class);
        mIntent.putExtra("mFilePath", url);
        startService(mIntent);
    }

    public void stopService(View view) {
        stopService(new Intent(this, BackgroundService.class));
    }
}
