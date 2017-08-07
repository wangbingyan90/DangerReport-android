package com.example.myapplication.Fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王炳炎 on 2017/8/4.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    TextView tvTitle;
    private List<String> datas;
    private LayoutInflater inflater;
    Context mContext=null;
    private ArrayList<ImageView> mImageViewList;
    public LinearLayout llContainer;
    private ImageView ivRedPoint;
    private int mPointDis;
    boolean a=true;
    @Override
    public int getItemViewType(int position) {
        if (position<1) return 0;
        if(position==1) return 2;
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
        }else if (viewType==2){
            itemView =inflater.inflate(R.layout.nexthome2,parent,false);
            return new Header2ViewHolder(itemView);
        }
        itemView =inflater.inflate(R.layout.recycler_item,null);
        return new ContentViewHolder(itemView);
    }


    //给每一行View填充数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.textview.setText(datas.get(position));
        if (holder instanceof HeaderViewHolder) {
            tvTitle=((HeaderViewHolder)holder).tvTitle;
            llContainer=((HeaderViewHolder)holder).llContainer;
            ivRedPoint= ((HeaderViewHolder)holder).ivRedPoint;
            if(a){
                initData();
                a=false;
            }

            ((HeaderViewHolder)holder).vp.setAdapter(new TopAdapter(mContext,mImageViewList));
            ((HeaderViewHolder)holder).vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(int arg0) {
                    // arg0是当前选中的页面的Position
                    tvTitle.setText("标题"+arg0);
                }

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    // arg0 :当前页面，及你点击滑动的页面；arg1:当前页面偏移的百分比；arg2:当前页面偏移的像素位置
                    // 更新小红点距离
                    int leftMargin = (int) (mPointDis * positionOffset) + position
                            * mPointDis;// 计算小红点当前的左边距
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ivRedPoint
                            .getLayoutParams();
                    params.leftMargin = leftMargin;// 修改左边距

                    // 重新设置布局参数
                    ivRedPoint.setLayoutParams(params);
                }

                @Override
                public void onPageScrollStateChanged(int arg0) {
                    //arg0 ==1的时表示正在滑动，arg0==2的时表示滑动完毕了，arg0==0的时表示什么都没做。
                    if(arg0 == 0){
                    }else if(arg0 == 1){
                    }else if(arg0 == 2){
                    }
                }
            });

            ivRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {

                        @Override
                        public void onGlobalLayout() {
                            // 移除监听,避免重复回调
                            ivRedPoint.getViewTreeObserver()
                                    .removeGlobalOnLayoutListener(this);
                            // ivRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            // layout方法执行结束的回调
                            mPointDis = llContainer.getChildAt(1).getLeft()
                                    - llContainer.getChildAt(0).getLeft();
                            System.out.println("圆点距离:" + mPointDis);
                        }
                    });


        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textview.setText(datas.get(position - 2));
        }
    }

    private void initData() {
        mImageViewList = new ArrayList<ImageView>();
        int[] mImageIds = {R.drawable.new1,R.drawable.new2,R.drawable.new3,R.drawable.new4};
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view = new ImageView(mContext);
            view.setBackgroundResource(mImageIds[i]);// 通过设置背景,可以让宽高填充布局
            // view.setImageResource(resId)
            mImageViewList.add(view);
//
            // 初始化小圆点
            ImageView point = new ImageView(mContext);
            point.setImageResource(R.drawable.shape_point_gray);// 设置图片(shape形状)

            // 初始化布局参数, 宽高包裹内容,父控件是谁,就是谁声明的布局参数
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i > 0) {
                // 从第二个点开始设置左边距
                params.leftMargin = 10;
            }

            point.setLayoutParams(params);// 设置布局参数

            llContainer.addView(point);// 给容器添加圆点
        }



    }

    //数据源的数量
    @Override
    public int getItemCount() {
        return datas.size()+2;
    }


    class ContentViewHolder extends RecyclerView.ViewHolder{
        private TextView textview;

        public ContentViewHolder(View itemView) {
            super(itemView);
            textview= (TextView) itemView.findViewById(R.id.textview);
        }
    }
    class Header2ViewHolder extends RecyclerView.ViewHolder{

        public Header2ViewHolder(View itemView) {
            super(itemView);
        }
    }



    class HeaderViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle;
        public ViewPager vp;
        public LinearLayout llContainer;
        public ImageView ivRedPoint;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.titlenext);
            vp = (ViewPager) itemView.findViewById(R.id.vp_next);
            llContainer = (LinearLayout) itemView.findViewById(R.id.ll_container);
            ivRedPoint = (ImageView)itemView.findViewById(R.id.iv_red_point);
        }
    }


}
