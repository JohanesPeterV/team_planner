package com.mobile_prog;

import android.app.Application;

import com.huawei.hms.ads.HwAds;

public class AdsHuawei extends Application {
    public void onCreate(){
        super.onCreate();
        HwAds.init(this);

    }
}
