package ac.test.liu.com.liuapplication;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;

import com.test.liu.adapter.MyAdapter;
import com.test.liu.application.BaseActivity;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/7/4.
 */

public class A000Activity extends BaseActivity {


    MyAdapter mRecyclerViewAdapter;
    List<String> list_data = null;

    @Bind(R.id.pullLoadMoreRecyclerView)
    PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;


    private int mCount = 1;
//    private RecyclerViewAdapter mRecyclerViewAdapter;


    private int mPage = 1;
    private boolean mIsRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a000);
        ButterKnife.bind(this);

//设置下拉刷新是否可见
        //mPullLoadMoreRecyclerView.setRefreshing(true);
        //设置是否可以下拉刷新
        //mPullLoadMoreRecyclerView.setPullRefreshEnable(true);
        //设置是否可以上拉刷新
        //mPullLoadMoreRecyclerView.setPushRefreshEnable(false);
        //显示下拉刷新
        mPullLoadMoreRecyclerView.setRefreshing(true);
        //设置上拉刷新文字
        mPullLoadMoreRecyclerView.setFooterViewText("加载中...");
        //设置上拉刷新文字颜色
        mPullLoadMoreRecyclerView.setFooterViewTextColor(R.color.white);
        //设置加载更多背景色
        mPullLoadMoreRecyclerView.setFooterViewBackgroundColor(R.color.colorBackground);
        mPullLoadMoreRecyclerView.setLinearLayout();

        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());
        mPullLoadMoreRecyclerView.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_view, null));//setEmptyView
        getData();
    }

    private void getData() {
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          if (mRecyclerViewAdapter == null) {
                                              mRecyclerViewAdapter = new MyAdapter(A000Activity.this, setList());
                                              mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
                                          } else {
                                              mRecyclerViewAdapter.getDataList().addAll(setList());
                                              mRecyclerViewAdapter.notifyDataSetChanged();
                                          }
                                          mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
                                      }
                                  }
                , 1000);

    }

//    public void clearData() {
//        mRecyclerViewAdapter.getDataList().clear();
//        mRecyclerViewAdapter.notifyDataSetChanged();
//    }


    private List<String> setList() {
        List<String> dataList = new ArrayList<>();
        int start = 20 * (mCount - 1);
        for (int i = start; i < 20 * mCount; i++) {
            dataList.add("Frist" + i);
        }
        return dataList;

    }


    class PullLoadMoreListener implements PullLoadMoreRecyclerView.PullLoadMoreListener {
        @Override
        public void onRefresh() {
            setRefresh();
            getData();
        }

        @Override
        public void onLoadMore() {
            Log.e("wxl", "onLoadMore");
            mCount = mCount + 1;
            getData();
        }

    }

    private void setRefresh() {
        mRecyclerViewAdapter.removeAllDataList();
        mCount = 1;
    }


    void initDatas(int page) {
        list_data = new ArrayList<String>();
        if (list_data != null) {
            list_data.clear();
        }
        int data_count = page * 10;
        for (int i = 0; i < data_count; i++) {
            list_data.add(i, "这是===" + i + "===个");
        }
    }


}
