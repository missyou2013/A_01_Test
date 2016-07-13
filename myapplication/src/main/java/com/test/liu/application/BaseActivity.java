package com.test.liu.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import ac.test.liu.com.liuapplication.R;


@SuppressLint("NewApi")
public abstract class BaseActivity extends AppCompatActivity {

    public static int SCREEN_WIDTH;// 屏幕宽度（像素，如：480px�?
    public static int SCREEN_HEIGHT;// 屏幕高度
    ImageView im_back;
    public static float SCREEN_DENSITY;// 屏幕密度（像素比例：0.75/1.0/1.5/2.0�?
    public static int SCREEN_DENSITYDPI; // 屏幕密度（每寸像素：120/160/240/320�?
    protected Context mContext = this;
    protected boolean mIsFront;
    protected byte activityType;
    protected BaseApplication mApp = BaseApplication.getSelf();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // 禁止横屏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        if (BaseApplication.screenWidth == 0) {
//            int width = getWindowManager().getDefaultDisplay().getWidth();
//            BaseApplication.screenWidth = width;
//        }
        init();
    }

    private void init() {
        SCREEN_WIDTH = getWindowManager().getDefaultDisplay().getWidth();
        SCREEN_HEIGHT = getWindowManager().getDefaultDisplay().getHeight();
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        SCREEN_DENSITY = dm.density;
        SCREEN_DENSITYDPI = dm.densityDpi;

    }

    /**
     * Back按钮隐藏
     */
    public void setHideLeftBtn() {
        View v = findViewById(R.id.title_btn_left);
        if (v == null)
            return;
        v.setVisibility(View.GONE);

    }

    /**
     * Back按钮退出 activity
     */
    public void setBackBtn() {
        View v = findViewById(R.id.title_btn_left);
        if (v == null)
            return;
        v.setVisibility(View.VISIBLE);
        ((ImageButton) v).setImageResource(R.mipmap.returnbtn);
        ((ImageButton) v).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置标题(int：从配置里读取，String：直接赋值)
     */
    public void setTopTitle(Object str) {
        View v = findViewById(R.id.title_txt);
        if (v == null)
            return;
        if (str instanceof String) {
            ((TextView) v).setText(String.valueOf(str));
        } else if (str instanceof Integer) {
            ((TextView) v).setText(((Integer) str).intValue());
        }
    }

    protected void onPause() {
        super.onPause();
        this.mIsFront = false;
    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (activityType == 0)
            mApp.push(this);
    }

    protected void onDestroy() {
        if (this.mContext == this)
            if (mApp != null)
                mApp.pull((Activity) this.mContext);
        super.onDestroy();
    }

    /**
     * 全屏
     */
    public void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 设置左边按钮文本
     */
    public void setLeftTxt(String str, OnClickListener click) {
        View v = findViewById(R.id.title_btn_left);
        if (v != null) {
            v.setVisibility(View.GONE);
        }
        View v2 = findViewById(R.id.title_btn_left_txt);
        if (v2 != null) {
            v2.setVisibility(View.VISIBLE);
            ((Button) v2).setText("" + str);
            v2.setOnClickListener(click);
        }
    }

    /**
     * 设置右边按钮文本
     */
    public void setRightTxt(String str, OnClickListener click) {
        View v = findViewById(R.id.title_btn_right);
        if (v != null) {
            v.setVisibility(View.GONE);
        }
        View v2 = findViewById(R.id.title_btn_right_txt);
        if (v2 != null) {
            v2.setVisibility(View.VISIBLE);
            ((Button) v2).setText("" + str);
            v2.setOnClickListener(click);
        }
    }

    /**
     * 添加右边按钮点击事件
     */
    public void setRightBtnClick(int resId, OnClickListener click) {
        View v = findViewById(R.id.title_btn_right);
        if (v == null)
            return;
        ((ImageButton) v).setImageResource(resId);
        ((ImageButton) v).setVisibility(View.VISIBLE);
        ((ImageButton) v).setOnClickListener(click);
    }
}
