package com.development.thomas.mobile_phone_masts.dagger.modules;

import android.arch.persistence.room.Room;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.database.AppDatabase;
import com.development.thomas.mobile_phone_masts.database.dao.MobilePhoneMastsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(MobilePhoneMastsApplication application) {
        //TODO: Should not allow main thread queries
        return Room.
                databaseBuilder(application.getApplicationContext(), AppDatabase.class, "MobilePhoneMast-Database")
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public MobilePhoneMastsDao providesMobilePhoneMastsDao(AppDatabase appDatabase) {
        return appDatabase.getMobilePhoneMastDao();
    }

}
