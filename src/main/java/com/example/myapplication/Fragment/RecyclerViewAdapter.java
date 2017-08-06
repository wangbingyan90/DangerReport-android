package com.example.myapplication.Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.View.TopViewPager;

import java.util.List;

/**
 * Created by 王炳炎 on 2017/8/4.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> datas;
    private LayoutInflater inflater;
    Context mContext=null;
    @Override
    public int getItemViewType(int position) {
        if (position<1) return 0;
        return 1;
    }


    public RecyclerViewAdapter(Context context, List<String> datas){
        mContext = context;
        inflater= LayoutInflater.from(context);
        this.datas=datas;
    }



    //创建每一行的View 用RecyclerView.ViewHolder包装
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        if(viewType==0){
            itemView =inflater.inflate(R.layout.nexthome,null);
            return new HeaderViewHolder(itemView);
        }
        itemView =inflater.inflate(R.layout.recycler_item,null);
        return new ContentViewHolder(itemView);
    }


    //给每一行View填充数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.textview.setText(datas.get(position));
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder)holder).vp.setAdapter(new TopAdapter(mContext,((HeaderViewHolder)holder).tvTitle));
//            ArrayList<ImageView> imageViews = null;
//            int[] img = {R.drawable.new1,R.drawable.new2,R.drawable.new3,R.drawable.new4};
//            for(int i=0 ;i<img.length;i++){
//                ImageView viewimg = new ImageView(mContext);
//                viewimg.setImageResource(img[i]);
//                imageViews.add(viewimg);
//            }


        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textview.setText(datas.get(position - 1));
        }
    }

    //数据源的数量
    @Override
    public int getItemCount() {
        return datas.size()+1;
    }


    class ContentViewHolder extends RecyclerView.ViewHolder{
        private TextView textview;

        public ContentViewHolder(View itemView) {
            super(itemView);
            textview= (TextView) itemView.findViewById(R.id.textview);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle;
        public TopViewPager vp;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.titlenext);
            vp = (TopViewPager) itemView.findViewById(R.id.vp_next);
        }
    }


}
