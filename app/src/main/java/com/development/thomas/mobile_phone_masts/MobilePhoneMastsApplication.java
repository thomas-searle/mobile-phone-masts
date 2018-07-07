package com.development.thomas.mobile_phone_masts;

import android.app.Application;

import com.development.thomas.mobile_phone_masts.dagger.ApplicationComponent;
import com.development.thomas.mobile_phone_masts.dagger.DaggerApplicationComponent;
import com.development.thomas.mobile_phone_masts.dagger.modules.ApplicationModule;
import com.facebook.stetho.Stetho;

public class MobilePhoneMastsApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Only initialise Stetho in DEBUG build mode
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

        // Setup Dagger Application Component
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    /**
     * Retrieve Dagger Application Component so classes can inject dependencies for themselves
     * @return
     */
    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
