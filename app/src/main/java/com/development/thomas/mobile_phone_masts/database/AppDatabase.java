package com.development.thomas.mobile_phone_masts.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.development.thomas.mobile_phone_masts.database.converters.DateConverter;
import com.development.thomas.mobile_phone_masts.database.dao.MobilePhoneMastsDao;
import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

@Database(entities = {MobilePhoneMast.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract MobilePhoneMastsDao getMobilePhoneMastDao();
}
