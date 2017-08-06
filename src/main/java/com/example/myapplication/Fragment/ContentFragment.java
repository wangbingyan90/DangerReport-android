package com.example.myapplication.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Base.BaseFragment;
import com.example.myapplication.Base.BasePager;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * Created by 王炳炎 on 2017/8/3.
 */

public class ContentFragment extends BaseFragment {


    ViewPager mViewPager;
    TabLayout mTab;
    ArrayList<BasePager> mPagers;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        mTab = (TabLayout) view.findViewById(R.id.tl_tab);
        mTab.setupWithViewPager(mViewPager);
        return view;
    }

    @Override
    public void initData() {
        mPagers = new ArrayList<BasePager>();
        mPagers.add(new HomePager(mActivity));
        mPagers.add(new ConnectPager(mActivity));
        mPagers.add(new repPager(mActivity));
        mPagers.add(new UserPager(mActivity));
        mViewPager.setAdapter(new ContentAdapter());


        mTab.setTabTextColors(ContextCompat.getColor(mActivity, R.color.black), ContextCompat.getColor(mActivity, R.color.white));

        mTab.getTabAt(0).setText("主页").setIcon(R.drawable.tab_home);
        mTab.getTabAt(1).setText("通知").setIcon(R.drawable.tab_connect);
        mTab.getTabAt(2).setText("联系人").setIcon(R.drawable.tab_rep);
        mTab.getTabAt(3).setText("我").setIcon(R.drawable.tab_user);

    }


    class ContentAdapter extends PagerAdapter {

//        @Override
//        public CharSequence getPageTitle(int position) {
//            return strings[position];
//        }


        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.mRootView;// 获取当前页面对象的布局

            // pager.initData();// 初始化数据, viewpager会默认加载下一个页面,
            // 为了节省流量和性能,不要在此处调用初始化数据的方法

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }


}
