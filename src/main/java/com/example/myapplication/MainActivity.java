package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.myapplication.Base.dada;
import com.example.myapplication.Fragment.ContentFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList imageViewList = new ArrayList<ImageView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int[] img = {R.drawable.new1,R.drawable.new2,R.drawable.new3,R.drawable.new4};
//        for(int i=0 ;i<img.length;i++){
//            ImageView viewimg = new ImageView(this);
//            viewimg.setBackgroundResource(img[i]);
//            imageViewList.add(viewimg);
//        }

//        dada.imageView = imageViewList;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();// 开始事务
        transaction.replace(R.id.fl_main,new ContentFragment(), "0");
        transaction.commit();


    }

}
