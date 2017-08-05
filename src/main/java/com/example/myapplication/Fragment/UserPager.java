package com.example.myapplication.Fragment;

import android.app.Activity;

import com.example.myapplication.Base.BasePager;

/**
 * Created by 王炳炎 on 2017/8/4.
 */

class UserPager extends BasePager {
    public UserPager(Activity mActivity) {
        super(mActivity);
    }
    @Override
    public void initData() {
        tvTitle.setText("个人中心");
    }
}
