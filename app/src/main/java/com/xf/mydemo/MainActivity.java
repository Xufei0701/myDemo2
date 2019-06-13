package com.xf.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xf.mydemo.adapter.MyAdapter;
import com.xf.mydemo.mvp.bean.GsonBean;
import com.xf.mydemo.mvp.contract.Contract;
import com.xf.mydemo.mvp.presenter.Presenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Contract.MyView {

    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.search)
    TextView search;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    private List<GsonBean.ListBean> list;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new MyAdapter(this);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new GridLayoutManager(this,3));
        final Presenter presenter=new Presenter(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map=new HashMap<>();
                map.put("q",editText.getText().toString());
                map.put("n","0");
                map.put("pn","50");
                presenter.getGson(map);
            }
        });

    }

    @Override
    public void success(Object data) {
        if (data instanceof GsonBean){
            list = ((GsonBean) data).getList();
                adapter.setList(list);
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }


}
