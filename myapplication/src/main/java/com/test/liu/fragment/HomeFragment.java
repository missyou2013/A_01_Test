package com.test.liu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ac.test.liu.com.liuapplication.A000Activity;
import ac.test.liu.com.liuapplication.HomeActivity;
import ac.test.liu.com.liuapplication.R;
import ac.test.liu.com.liuapplication.readme.io.MainActivity;
import ac.test.liu.com.liuapplication.rxjava.RxJavaRetrofit2Activity;
import ac.test.liu.com.liuapplication.rxjava.RxJavaRetrofit2Activity_02;
import ac.test.liu.com.liuapplication.rxjava.RxJavaRetrofit2Activity_03;
import ac.test.liu.com.liuapplication.rxjava.rxjavaretrofitdemo.activity.MainTestActivity;
import ac.test.liu.com.liuapplication.tablayout.Tablayout2Activity;
import ac.test.liu.com.liuapplication.tablayout.Tablayout3Activity;
import ac.test.liu.com.liuapplication.tablayout.TablayoutActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author Administrator
 * @ClassName HomeFragment
 * @Description 首页fragment
 * @history 1.YYYY-MM-DD author: description:
 */
public class HomeFragment extends Fragment {

    @Bind(R.id.h_recyleview)
    Button hRecyleview;
    @Bind(R.id.h_tab)
    Button hTab;
    @Bind(R.id.h_tab_2)
    Button hTab2;
    @Bind(R.id.h_tab_3)
    Button hTab3;
    @Bind(R.id.h_tab_4)
    Button hTab4;
    @Bind(R.id.h_tab_5)
    Button hTab5;
    @Bind(R.id.h_tab_6)
    Button hTab6;
    @Bind(R.id.h_tab_7)
    Button hTab7;
    @Bind(R.id.h_tab_8)
    Button hTab8;
    private HomeActivity homeActivity;
    private View rootView;


    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        homeActivity = (HomeActivity) getActivity();
        initView();
        ButterKnife.bind(this, rootView);
        return rootView;

    }


    // 初始化数据
    private void initView() {


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.h_recyleview, R.id.h_tab, R.id.h_tab_2, R.id.h_tab_3, R.id.h_tab_4, R.id.h_tab_5, R.id.h_tab_6, R.id.h_tab_7

            , R.id.h_tab_8
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.h_recyleview:
                Intent intent = new Intent(homeActivity, A000Activity.class);
                homeActivity.startActivity(intent);
                break;
            case R.id.h_tab:
                Intent intent2 = new Intent(homeActivity, TablayoutActivity.class);
                homeActivity.startActivity(intent2);
                break;
            case R.id.h_tab_2:
                Intent intent3 = new Intent(homeActivity, Tablayout2Activity.class);
                homeActivity.startActivity(intent3);
                break;
            case R.id.h_tab_3:
                Intent intent4 = new Intent(homeActivity, Tablayout3Activity.class);
                homeActivity.startActivity(intent4);
                break;
            case R.id.h_tab_4:
                Intent intent5 = new Intent(homeActivity, MainActivity.class);
                homeActivity.startActivity(intent5);
                break;
            case R.id.h_tab_5:
                Intent intent6 = new Intent(homeActivity, RxJavaRetrofit2Activity.class);
                homeActivity.startActivity(intent6);
                break;
            case R.id.h_tab_6:
                Intent intent7 = new Intent(homeActivity, RxJavaRetrofit2Activity_02.class);
                homeActivity.startActivity(intent7);
                break;
            case R.id.h_tab_7:
                Intent intent8 = new Intent(homeActivity, RxJavaRetrofit2Activity_03.class);
                homeActivity.startActivity(intent8);
                break;
            case R.id.h_tab_8:
                Intent intent9 = new Intent(homeActivity, MainTestActivity.class);
                homeActivity.startActivity(intent9);
                break;
        }
    }


    @OnClick(R.id.h_tab_8)
    public void onClick() {
    }
}
