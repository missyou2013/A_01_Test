package com.test.liu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ac.test.liu.com.liuapplication.HomeActivity;
import ac.test.liu.com.liuapplication.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Administrator
 * @ClassName ServiceFragment
 * @Description 客服fragment
 * @date 2015-7-8 下午8:12:17
 * @history 1.YYYY-MM-DD author: description:
 */
public class ServiceFragment extends Fragment {
    @Bind(R.id.fragment_iv_1)
    ImageView fragmentIv1;
    @Bind(R.id.fragment_iv_2)
    ImageView fragmentIv2;
    @Bind(R.id.fragment_iv_3)
    ImageView fragmentIv3;
    @Bind(R.id.fragment_iv_4)
    ImageView fragmentIv4;
    @Bind(R.id.fragment_iv_5)
    ImageView fragmentIv5;
    @Bind(R.id.fragment_iv_6)
    ImageView fragmentIv6;
    @Bind(R.id.profile_image)
    CircleImageView profileImage;


    private HomeActivity homeActivity;
    private View rootView;
    private String imageUrl1 = "http://imgs.xiuna.com/xiezhen/2014-9-25/2/5562900520140919100645087.jpg";

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        rootView = inflater.inflate(R.layout.fragment_service, container, false);
        homeActivity = (HomeActivity) getActivity();
        ButterKnife.bind(this, rootView);

        initView();
        initData();

        return rootView;
    }

    // 初始化view
    private void initData() {
        // TODO Auto-generated method stub
        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .into(fragmentIv1);
        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso2/cover.jpg")
                .error(R.mipmap.ic_error)
                .into(fragmentIv2);
        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso3/cover.jpg")
                .placeholder(R.mipmap.ic_empty)
                .into(fragmentIv3);
        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .centerCrop()
                .into(fragmentIv4);
        Glide.with(this)
                .load(imageUrl1)
                .error(R.mipmap.ic_error)
                .placeholder(R.mipmap.ic_empty)
                .into(fragmentIv5);

        Glide.with(this)
                .load(imageUrl1+"55")
                .error(R.mipmap.ic_error)
                .placeholder(R.mipmap.ic_empty)
                .fallback(R.mipmap.ic_empty)
                .into(fragmentIv6);

        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .into(profileImage);

    }

    // 初始化数据
    private void initView() {
        // TODO Auto-generated method stub

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
