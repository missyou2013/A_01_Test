package com.test.liu.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ac.test.liu.com.liuapplication.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {


    private List<String> mDatas = null;
    private Context context = null;
    private LayoutInflater mInflater = null;
    private OnItemClickListener mOnItemClickListener;

    public List<String> getDataList() {
        return mDatas;
    }

    public void removeAllDataList() {
        this.mDatas.removeAll(mDatas);
    }
    public MyAdapter(Context context, List<String> data) {
        super();
        this.mDatas = data;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.zhinenganbao_img)
        ImageView mItemImg;
        @Bind(R.id.zhinenganbao_text)
        TextView mItemText;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getPosition(),v.getTag());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder viewHolder, int position) {
        viewHolder.mItemImg.setImageResource(R.mipmap.ic_launcher);
        viewHolder.mItemText.setText(mDatas.get(position));
        //将数据保存在itemView的Tag中，以便点击时进行获取
        viewHolder.itemView.setTag(mDatas.get(position));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.item_zhinenganbao_gridview, parent, false);
        ItemViewHolder holder = new ItemViewHolder(v);
        return holder;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }
}
