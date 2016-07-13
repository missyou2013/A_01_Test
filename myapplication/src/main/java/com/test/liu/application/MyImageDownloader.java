package com.test.liu.application;

import android.content.Context;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Administrator on 2016/3/29.
 */
public class MyImageDownloader extends BaseImageDownloader {
    public MyImageDownloader(Context context) {
        super(context);
    }

    public MyImageDownloader(Context context, int connectTimeout, int readTimeout) {
        super(context, connectTimeout, readTimeout);
    }

    @Override
    protected HttpURLConnection createConnection(String url, Object extra) throws IOException {
        HttpURLConnection conn = super.createConnection(url, extra);
        conn.setRequestProperty("Content-Length", "0");
        return conn;
    }

}
