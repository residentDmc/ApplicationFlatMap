package com.example.applicationflatmap;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.applicationflatmap.MapFlap.ItemList;

import java.io.File;
import java.util.Calendar;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class BackgroundService extends IntentService {

    private NotificationManager nm;
    private final Calendar time = Calendar.getInstance();
    private CompositeDisposable disposables = new CompositeDisposable();

    public BackgroundService() {
        super("");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        doFileUpload(intent);
    }

    private void doFileUpload(Intent intent) {
        String mFilePath = intent.getStringExtra("mFilePath");
        if (mFilePath == null) {
            Log.e(TAG, "onHandleWork: Invalid file URI");
            return;
        }
        UploadFile(mFilePath).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposables.add(d);
            }

            @Override
            public void onNext(String s) {
                sendBroadcastMeaasge(s);
            }

            @Override
            public void onError(Throwable e) {
                sendBroadcastMeaasge(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }


    private Observable<String> UploadFile(String mFilePath) {
        return ServiceGenerator.getRequestApi()
                .onFileUpload(createMultipartBody(mFilePath))
                .map(s -> {
                    sendBroadcastMeaasge(s);
                    return s;
                })
                .subscribeOn(Schedulers.io());
    }


    private MultipartBody.Part createMultipartBody(String filePath) {
        File file = new File(filePath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        return MultipartBody.Part.createFormData("mediaFiles", file.getName(), requestFile);
    }

    public void sendBroadcastMeaasge(String message) {
        Intent localIntent = new Intent("my.own.broadcast");
        localIntent.putExtra("result", message);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Toast.makeText(this, "Service created at " + time.getTime(),
                Toast.LENGTH_LONG).show();
        // showNotification();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Cancel the persistent notification.
        // nm.cancel(R.string.service_started);
        Toast.makeText(this,
                " Service destroyed at " + time.getTime() + ";",
                Toast.LENGTH_LONG).show();
    }
}