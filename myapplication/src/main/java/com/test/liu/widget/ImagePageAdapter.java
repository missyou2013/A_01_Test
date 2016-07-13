package com.test.liu.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * @author lxj
 * @ClassName ImagePageAdapter
 * @Description 加载本地图片adapter
 * @date 2015-8-14 下午3:40:38
 * @history 1.YYYY-MM-DD author: description:
 */
public class ImagePageAdapter extends PagerAdapter {
    private List<ImageView> banners;
    private ImagePageAdapterListener mListener;

    public ImagePageAdapter(Context context, int pageCount) {
        banners = new ArrayList<ImageView>(pageCount);
        initBanners(context, pageCount);
    }

    public void addImagePageAdapterListener(ImagePageAdapterListener imagePageAdapterListener) {
        mListener = imagePageAdapterListener;
    }

    private void initBanners(Context context, int pageCount) {
        pageCount = pageCount + 2;
        for (int index = 0; index < pageCount; index++) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            banners.add(imageView);
        }
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ImageView banner = banners.get(position);
        if (mListener != null) {
            if (position == 0) {
                mListener.dispalyImage(banner, getCount() - 2 - 1);
            } else if (position == getCount() - 1) {
                mListener.dispalyImage(banner, 0);
            } else {
                mListener.dispalyImage(banner, position - 1);
            }
        }
        ((ViewPager) container).addView(banner);
        return banner;
    }

    public interface ImagePageAdapterListener {
        void dispalyImage(ImageView banner, int position);
    }

}
