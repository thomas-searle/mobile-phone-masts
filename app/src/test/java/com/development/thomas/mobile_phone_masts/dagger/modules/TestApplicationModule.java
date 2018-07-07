package com.development.thomas.mobile_phone_masts.dagger.modules;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestApplicationModule {

    @Provides
    @Singleton
    public MobilePhoneMastsApplication providesMobilePhoneMastsApplication() {
        return Mockito.mock(MobilePhoneMastsApplication.class);
    }
}
