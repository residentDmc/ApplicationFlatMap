package com.example.applicationflatmap;

import com.example.applicationflatmap.MapFlap.ItemList;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface RequestApi {

    @POST("Public/Getprovince")
    Observable<List<ItemList>> Getprovince();

    @POST()
    Observable<List<ItemList>> GetCity(@Url String url);

    @Multipart
    @POST("Media/sendFile")
    Observable<String> onFileUpload(@Part MultipartBody.Part file);
}
