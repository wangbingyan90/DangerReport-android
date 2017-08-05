package com.example.myapplication.Fragment;

import android.app.Activity;

import com.example.myapplication.Base.BasePager;

/**
 * Created by 王炳炎 on 2017/8/3.
 */

class HomePager extends BasePager {
    public HomePager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {
        tvTitle.setText("主页");
        HomeNextPager hn = new HomeNextPager(mActivity);

        nextFrame.removeAllViews();

        nextFrame.addView(hn.mRootView);



    }
}
