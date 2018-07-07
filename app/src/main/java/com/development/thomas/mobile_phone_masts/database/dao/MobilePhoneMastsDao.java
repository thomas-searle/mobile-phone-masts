package com.development.thomas.mobile_phone_masts.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import java.util.List;

@Dao
public interface MobilePhoneMastsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MobilePhoneMast mobilePhoneMast);

    @Query("DELETE FROM mobilephonemast")
    void clear();

    @Query("SELECT COUNT(*) FROM mobilephonemast")
    int rowsOfData();

    @Query("SELECT * FROM mobilephonemast")
    List<MobilePhoneMast> getMobilePhoneMasts();

    @Query("SELECT * FROM mobilephonemast ORDER BY current_rent LIMIT :maximumNumberOfResults")
    List<MobilePhoneMast> getMobilePhoneMastsAscending(int maximumNumberOfResults);

    @Query("SELECT * FROM mobilephonemast ORDER BY current_rent DESC LIMIT :maximumNumberOfResults")
    List<MobilePhoneMast> getMobilePhoneMastsDescending(int maximumNumberOfResults);

}
