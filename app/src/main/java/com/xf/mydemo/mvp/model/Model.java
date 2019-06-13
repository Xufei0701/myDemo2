package com.xf.mydemo.mvp.model;

import com.xf.mydemo.mvp.bean.GsonBean;
import com.xf.mydemo.mvp.contract.Contract;
import com.xf.mydemo.mvp.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;

public class Model implements Contract.MyModel {
    @Override
    public Observable<GsonBean> getGson(HashMap<String, String> map) {
        return RetrofitUtils.getInstance().api().getGson(map);
    }
}
