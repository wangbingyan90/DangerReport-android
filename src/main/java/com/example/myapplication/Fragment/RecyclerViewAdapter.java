package com.example.myapplication.Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

/**
 * Created by 王炳炎 on 2017/8/4.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private List<String> datas;
    private LayoutInflater inflater;
    public RecyclerViewAdapter(Context context, List<String> datas){
        inflater= LayoutInflater.from(context);
        this.datas=datas;
    }
    //创建每一行的View 用RecyclerView.ViewHolder包装
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.recycler_item,null);
        return new MyViewHolder(itemView);
    }
    //给每一行View填充数据
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textview.setText(datas.get(position));
    }
    //数据源的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textview;

        public MyViewHolder(View itemView) {
            super(itemView);
            textview= (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
