package com.development.thomas.mobile_phone_masts.dagger.modules;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final MobilePhoneMastsApplication mobilePhoneMastsApplication;

    public ApplicationModule(MobilePhoneMastsApplication mobilePhoneMastsApplication) {
        this.mobilePhoneMastsApplication = mobilePhoneMastsApplication;
    }

    @Provides
    public MobilePhoneMastsApplication providesMobilePhoneMastsApplication() {
        return mobilePhoneMastsApplication;
    }
}
