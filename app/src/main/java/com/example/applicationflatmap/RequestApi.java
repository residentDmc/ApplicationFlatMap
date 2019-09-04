package com.example.applicationflatmap;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RequestApi {

    @POST("Public/Getprovince")
    Observable<List<ItemList>> Getprovince();

    @POST()
    Observable<List<ItemList>> GetCity(@Url String url);
}
