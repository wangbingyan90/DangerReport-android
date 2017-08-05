package com.example.myapplication.Fragment;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.View.TopViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 王炳炎 on 2017/8/4.
 */

class HomeNextPager {
    private RecyclerViewAdapter mSectionedAdapter;
    List<String> datas;
    public Activity mActivity;
    public View mRootView;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    public TextView tvTitle;
    public TopViewPager vp;
    public HomeNextPager(Activity mActivity) {
        this.mActivity = mActivity;
        mRootView = initView();
        inidata();
    }

    private void inidata() {

        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, android.R.color.holo_blue_bright, R.color.colorPrimaryDark,
                android.R.color.holo_orange_dark, android.R.color.holo_red_dark, android.R.color.holo_purple);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                // TODO 获取数据
                final Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.add(0, "后加" + random.nextInt(100) + "号");
                        mSectionedAdapter.notifyDataSetChanged();

                        Toast.makeText(mActivity, "刷新了一条数据", Toast.LENGTH_SHORT).show();

                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1200);

            }
        });
        datas=new ArrayList<>();
        for(int i=0;i<100;i++){
            datas.add("item:"+i);
        }
        mSectionedAdapter = new RecyclerViewAdapter(mActivity,datas);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSectionedAdapter);
    }




    private View initView() {
        View view = View.inflate(mActivity, R.layout.fragmentnexthome, null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        return view;
    }



//    private void inidata() {
//        tvTitle.setText("标题");
//        vp.setAdapter(new TopAdapter());
//
//    }
//    private View initView() {
//        View view = View.inflate(mActivity, R.layout.nexthome, null);
//        tvTitle = (TextView) view.findViewById(R.id.titlenext);
//        vp = (TopViewPager) view.findViewById(R.id.vp_next);
//        return view;
//
//    }
//
//
//    // 头条新闻数据适配器
//    class TopAdapter extends PagerAdapter {
//        int[] img = {R.drawable.new1,R.drawable.new2,R.drawable.new3,R.drawable.new4};
//
//        public TopAdapter() {
////           图片获取
//        }
//
//        @Override
//        public int getCount() {
//            return img.length;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            tvTitle.setText("标题"+position);
//            ImageView view = new ImageView(mActivity);
//            view.setImageResource(img[position]);
//            view.setScaleType(ImageView.ScaleType.FIT_XY);
//
//            container.addView(view);
//
//            return view;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
//
//    }


}
