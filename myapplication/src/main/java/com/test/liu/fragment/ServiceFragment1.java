package com.test.liu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import ac.test.liu.com.liuapplication.HomeActivity;
import ac.test.liu.com.liuapplication.R;

/**
 * @ClassName ServiceFragment
 * @Description 客服fragment
 * @author Administrator
 * @date 2015-7-8 下午8:12:17
 * @history 1.YYYY-MM-DD author: description:
 */
public class ServiceFragment1 extends Fragment {
	private HomeActivity homeActivity;
	private View rootView;
	private boolean hadIntercept;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.fragment_home, container, false);
		homeActivity = (HomeActivity) getActivity();
		initView();
		initData();
		return rootView;
	}

	// 初始化view
	private void initData() {
		// TODO Auto-generated method stub

	}

	// 初始化数据
	private void initView() {
		// TODO Auto-generated method stub

	}

}
