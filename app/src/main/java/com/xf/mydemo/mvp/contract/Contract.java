package com.xf.mydemo.mvp.contract;

import com.xf.mydemo.mvp.bean.GsonBean;

import java.util.HashMap;

import io.reactivex.Observable;

public interface Contract {
    public interface MyView<T>{
        void success(T data);
        void failure(Throwable throwable);
    }
    public interface MyModel{
        Observable<GsonBean> getGson(HashMap<String,String> map);
    }
    public interface MyPresenter{
        void getGson(HashMap<String,String> map);
    }
}
