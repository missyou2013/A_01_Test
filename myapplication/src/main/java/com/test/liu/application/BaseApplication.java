package com.test.liu.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ac.test.liu.com.liuapplication.R;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;

public class BaseApplication extends Application {
    public static BaseApplication mApp = null;
    public List<Activity> mActivitys = new ArrayList();
    public static int screenWidth = 0;
    public long exitTime = 0;
    public String base_url_pk_http = "https://publicobject.com/helloworld.txt";

    public static BaseApplication getSelf() {
        return mApp;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = (BaseApplication) getApplicationContext();
        initError();

        //初始化Fresco
//        Fresco.initialize(mApp);

        //初始化OkHttpFinal
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        builder.setTimeout(1000 * 30).setDebug(true);

        // 初始化ImageLoader
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_stub)
                .showImageForEmptyUri(R.mipmap.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                // .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .build(); // 创建配置过得DisplayImageOption对象
        ImageLoaderConfiguration config = new
                ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(options)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .memoryCache(new WeakMemoryCache())
                .writeDebugLogs()
                .imageDownloader(new MyImageDownloader(mApp))
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }

    public void pull(Activity paramActivity) {
        for (int i = 0; i < mActivitys.size(); i++) {
            if (this.mActivitys.get(i) == paramActivity) {
                this.mActivitys.remove(i);
                return;
            }
        }
    }

    public void push(Activity paramActivity) {
        for (int i = 0; i < mActivitys.size(); i++) {
            if (this.mActivitys.get(i) == paramActivity) {
                this.mActivitys.add(paramActivity);
                return;
            }
        }
    }

    public void exit(Context context) {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            exitTime = System.currentTimeMillis();
        } else {
            for (Activity activity : mActivitys) {
                activity.finish();
            }
            // 退回到桌面，假退出
            // Intent i = new Intent(Intent.ACTION_MAIN);
            // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // i.addCategory(Intent.CATEGORY_HOME);
            // context.startActivity(i);
        }
    }

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, String> errorMap = new HashMap<Integer, String>();

    private void initError() {
        errorMap.put(1, "查询成功");
        errorMap.put(-1, "未登录");
        errorMap.put(-2, "参数不全");
        errorMap.put(-3, "手机号或密码不正确");
        errorMap.put(-4, "短信验证码错误");
        errorMap.put(-5, "手机号码已存在");
    }

    /**
     * 根据status获取错误信息
     *
     * @param status
     * @return
     */
    public String getError(int status) {
        if (errorMap.containsKey(status))
            return errorMap.get(status);
        return "";
    }

}
