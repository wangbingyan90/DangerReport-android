package com.example.myapplication.Fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * Created by 王炳炎 on 2017/8/6.
 */

class TopAdapter extends PagerAdapter {
    ArrayList<ImageView> imageViews=null;
    int[] img = {R.drawable.new1,R.drawable.new2,R.drawable.new3,R.drawable.new4};
    Context mContext;
        public TopAdapter(Context mContext, ArrayList<ImageView> mImageViewList) {
            this.mContext = mContext;
            imageViews = mImageViewList;
//            for(int i=0 ;i<img.length;i++){
//                ImageView viewimg = new ImageView(mContext);
//                viewimg.setImageResource(img[i]);
//                imageViews.add(viewimg);
//            }



//           图片获取
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            ImageView view = new ImageView(mContext);
//            view.setImageResource(img[position]);
//
//            view.setScaleType(ImageView.ScaleType.FIT_XY);
////
//            container.addView(view);
//
//            return view;
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

}
