package com.development.thomas.mobile_phone_masts;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MobilePhoneMastsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Only initialise Stetho in DEBUG build mode
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
