package com.bluewebspark.dbtestproject;

import android.app.Application;

import com.bluewebspark.dbtestproject.data.datahelper.TestDataHelper;

public class AppControlar extends Application {
    public static AppControlar mInstance;

    public static synchronized AppControlar getmInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        new TestDataHelper(this);
    }
}
