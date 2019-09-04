package com.example.applicationflatmap;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static com.example.applicationflatmap.Tools.setSystemBarColor;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponentMenu();
        setSystemBarColor(this, R.color.grey_1000);


        getProvinceObservable()
                .subscribeOn(Schedulers.io())
                .flatMap((Function<ItemList, ObservableSource<ItemList>>) this::getCity)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(ItemList post) {
                        province(post);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private Observable<ItemList> getCity(ItemList itemList) {
        return ServiceGenerator.getRequestApi()
                .GetCity("Public/GetCity?ProvinceId="+itemList.getId())
                .map(itemLists -> {
                    itemList.setItemLists(itemLists);
                    return itemList;
                })
                .subscribeOn(Schedulers.io());
    }

    private void province(ItemList post) {
        Log.i(TAG, "province: "+post);
    }

    private void province(List<ItemList> posts) {
        Log.i(TAG, "province: "+posts);
    }

    private Observable<ItemList> getProvinceObservable(){
        return ServiceGenerator.getRequestApi()
                .Getprovince()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap((Function<List<ItemList>, ObservableSource<ItemList>>) posts -> {
                    province(posts);
                    return Observable.fromIterable(posts)
                            .subscribeOn(Schedulers.io());
                });
    }

    private void initComponentMenu() {
        RecyclerView recycler = findViewById(R.id.main_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setNestedScrollingEnabled(false);
    }
}
