package com.development.thomas.mobile_phone_masts.dagger.modules;

import android.arch.persistence.room.Room;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.database.AppDatabase;
import com.development.thomas.mobile_phone_masts.database.dao.MobilePhoneMastsDao;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestDatabaseModule {

    @Provides
    @Singleton
    public MobilePhoneMastsDao providesMobilePhoneMastsDao() {
        return Mockito.mock(MobilePhoneMastsDao.class);
    }

}
