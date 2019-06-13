package com.xf.mydemo.mvp.bean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiService {
    @POST("j")
    Observable<GsonBean> getGson(@QueryMap HashMap<String,String> map);
}
