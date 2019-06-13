package com.xf.mydemo.mvp.utils;

import com.xf.mydemo.mvp.bean.Api;
import com.xf.mydemo.mvp.bean.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static RetrofitUtils mInstant;
    private final Retrofit retrofit;

    public static RetrofitUtils getInstance(){
        if (mInstant==null){
            synchronized (RetrofitUtils.class){
                if (mInstant==null){
                    mInstant=new RetrofitUtils();
                }
            }
        }
        return mInstant;
    }

    private RetrofitUtils(){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(loggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.API)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public ApiService api(){
        return retrofit.create(ApiService.class);
    }

}
