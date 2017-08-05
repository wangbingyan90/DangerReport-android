package com.example.myapplication.Base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * Created by 王炳炎 on 2017/8/3.
 */

public class BasePager {
    public Activity mActivity;
    public View mRootView;
    public TextView tvTitle;
    public FrameLayout nextFrame;

    public BasePager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
        initData();
    }

    private View initView() {
        View view = View.inflate(mActivity, R.layout.firstvp, null);
        tvTitle = (TextView) view.findViewById(R.id.title);
        nextFrame = (FrameLayout) view.findViewById(R.id.fl_content);
        return view;
    }
    public void initData() {

    }

}
