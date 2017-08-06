package com.example.myapplication.Fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * Created by 王炳炎 on 2017/8/6.
 */

class TopAdapter extends PagerAdapter {
    ArrayList<ImageView> imageViews=null;
    int[] img = {R.drawable.new1,R.drawable.new2,R.drawable.new3,R.drawable.new4};
    TextView tvTitle;
    Context mContext;
        public TopAdapter(Context mContext, TextView tvTitle) {
            this.tvTitle=tvTitle;
            this.mContext = mContext;

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
            tvTitle.setText("标题"+position);
//            ImageView view = new ImageView(mContext);
//            view.setImageResource(img[position]);
//
//            view.setScaleType(ImageView.ScaleType.FIT_XY);
//
//            container.addView(view);
//            container.addView(imageViews.get(position));
            return null;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

}
