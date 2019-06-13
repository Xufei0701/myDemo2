package com.xf.mydemo.mvp.presenter;

import com.xf.mydemo.mvp.bean.GsonBean;
import com.xf.mydemo.mvp.contract.Contract;
import com.xf.mydemo.mvp.model.Model;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Presenter implements Contract.MyPresenter {
    Model model;
    Contract.MyView myView;

    public Presenter(Contract.MyView myView) {
        this.myView = myView;
        model=new Model();
    }

    @Override
    public void getGson(HashMap<String, String> map) {
        model.getGson(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GsonBean>() {
                    @Override
                    public void accept(GsonBean gsonBean) throws Exception {
                        myView.success(gsonBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        myView.failure(throwable);
                    }
                });
    }


}
