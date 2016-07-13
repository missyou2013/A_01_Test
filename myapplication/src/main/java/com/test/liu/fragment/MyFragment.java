package com.test.liu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.test.liu.widget.ImageCycleView;

import java.util.ArrayList;

import ac.test.liu.com.liuapplication.HomeActivity;
import ac.test.liu.com.liuapplication.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator
 * @ClassName MyFragment
 * @Description 我的fragment
 * @date 2015-7-8 下午8:12:17
 * @history 1.YYYY-MM-DD author: description:
 */
public class MyFragment extends Fragment {
    @Bind(R.id.fragment_top_title_left)
    ImageButton fragmentTopTitleLeft;
    @Bind(R.id.fragment_top_title_center)
    TextView fragmentTopTitleCenter;
    @Bind(R.id.fragment_top_title_right)
    TextView fragmentTopTitleRight;
//    @Bind(R.id.my_image_view)
//    SimpleDraweeView myImageView;
    @Bind(R.id.ad_view)
    ImageCycleView mAdView;
    private HomeActivity homeActivity;
    private View rootView;
    private String imageUrl22 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";
    private ArrayList<String> mImageUrl = null;

    private String imageUrl1 = "http://imgs.xiuna.com/xiezhen/2014-9-25/2/5562900520140919100645087.jpg";

    private String imageUrl2 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";

    private String imageUrl3 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";

    private String imageUrl4 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeActivity = (HomeActivity) getActivity();
        rootView = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, rootView);

        initView();
        initData();
        return rootView;

    }

    // 初始化view
    private void initData() {

    }

    // 初始化数据
    private void initView() {
//        Uri uri = Uri.parse(imageUrl22);
//        myImageView.setImageURI(uri);
        mImageUrl = new ArrayList<String>();
        mImageUrl.add(imageUrl1);
        mImageUrl.add(imageUrl2);
        mImageUrl.add(imageUrl3);
        mImageUrl.add(imageUrl4);
        mAdView.setImageResources(mImageUrl, mAdCycleViewListener);
    }

    private ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {

        @Override
        public void onImageClick(int position, View imageView) {
            // TODO 单击图片处理事件
//            Toast.makeText(homeActivity, "position->" + position, 0).show();
//            Intent intent = new Intent((HomeActivity) getActivity(), A000Activity.class);
//            ((HomeActivity) getActivity()).startActivity(intent);
        }

        @Override
        public void displayImage(String imageURL, ImageView imageView) {
            ImageLoader.getInstance().displayImage(imageURL, imageView);// 此处本人使用了ImageLoader对图片进行加装！
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.startImageCycle();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mAdView != null) {
            mAdView.pushImageCycle();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mAdView != null) {
            mAdView.pushImageCycle();
        }
    }

    @OnClick({R.id.fragment_top_title_left, R.id.fragment_top_title_center, R.id.fragment_top_title_right })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_top_title_left:
                break;
            case R.id.fragment_top_title_center:
                break;
            case R.id.fragment_top_title_right:
                break;

        }
    }
}
