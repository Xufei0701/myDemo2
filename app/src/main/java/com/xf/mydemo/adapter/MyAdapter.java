package com.xf.mydemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xf.mydemo.R;
import com.xf.mydemo.mvp.bean.GsonBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;


    public MyAdapter(Context context) {
        this.context = context;
    }

    List<GsonBean.ListBean> list;

    public void setList(List<GsonBean.ListBean> list) {
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.frescoImage.setImageURI(Uri.parse(list.get(i).getImg()));
        viewHolder.imageName.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fresco_image)
        SimpleDraweeView frescoImage;
        @BindView(R.id.image_name)
        TextView imageName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
