package com.development.thomas.mobile_phone_masts.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.development.thomas.mobile_phone_masts.database.AppDatabase;
import com.development.thomas.mobile_phone_masts.database.MobilePhoneMastTestUtil;
import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class MobilePhoneMastDaoTests {

    private AppDatabase testDatabase;
    private MobilePhoneMastsDao mobilePhoneMastsDao;

    private final int numberOfMastsToGet = 5;

    @Before
    public void createDatabase() {
        Context context = InstrumentationRegistry.getTargetContext();
        testDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mobilePhoneMastsDao = testDatabase.getMobilePhoneMastDao();
    }

    @After
    public void closeDb() throws IOException {
        testDatabase.close();
    }

    @Test
    public void createMobilePhoneMast() {
        String propertyName = "propertyName";
        MobilePhoneMast mobilePhoneMast = MobilePhoneMastTestUtil.createWithDefaults();
        mobilePhoneMast.propertyName = propertyName;

        mobilePhoneMastsDao.insert(mobilePhoneMast);
        List<MobilePhoneMast> mobilePhoneMasts = mobilePhoneMastsDao.getMobilePhoneMasts();

        Assert.assertNotNull(mobilePhoneMasts);
        Assert.assertEquals(1, mobilePhoneMasts.size());
        Assert.assertEquals(propertyName, mobilePhoneMasts.get(0).propertyName);
    }

    @Test
    public void clearMobilePhoneMastTest() {
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithDefaults());

        List<MobilePhoneMast> mobilePhoneMasts = mobilePhoneMastsDao.getMobilePhoneMasts();
        Assert.assertTrue(mobilePhoneMasts.size() > 0);

        mobilePhoneMastsDao.clear();

        mobilePhoneMasts = mobilePhoneMastsDao.getMobilePhoneMasts();
        Assert.assertEquals(0, mobilePhoneMasts.size());
    }

    @Test
    public void countMobilePhoneMastTest() {
        int rowCount = mobilePhoneMastsDao.rowsOfData();

        Assert.assertEquals(0, rowCount);

        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithDefaults());
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithDefaults());
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithDefaults());

        rowCount = mobilePhoneMastsDao.rowsOfData();
        Assert.assertEquals(3, rowCount);

    }

    @Test
    public void getMobilePhoneMastAscTest() {
        createTestDataWithRent();

        List<MobilePhoneMast> mobilePhoneMasts = mobilePhoneMastsDao.getMobilePhoneMastsAscending(numberOfMastsToGet);

        Assert.assertNotNull(mobilePhoneMasts);
        Assert.assertEquals(numberOfMastsToGet, mobilePhoneMasts.size());

        // Test that results are returned in asc current rent
        float previousRentAmount = 0f;
        for (MobilePhoneMast mobilePhoneMast: mobilePhoneMasts) {
            Assert.assertTrue(previousRentAmount <= mobilePhoneMast.currentRent);
            previousRentAmount = mobilePhoneMast.currentRent;
        }
    }

    @Test
    public void getMobilePhoneMastDescTest() {
        createTestDataWithRent();

        List<MobilePhoneMast> mobilePhoneMasts = mobilePhoneMastsDao.getMobilePhoneMastsDescending(numberOfMastsToGet);

        Assert.assertNotNull(mobilePhoneMasts);
        Assert.assertEquals(numberOfMastsToGet, mobilePhoneMasts.size());

        // Test that results are returned in desc current rent
        float previousRentAmount = Float.MAX_VALUE;
        for (MobilePhoneMast mobilePhoneMast: mobilePhoneMasts) {
            Assert.assertTrue(previousRentAmount >= mobilePhoneMast.currentRent);
            previousRentAmount = mobilePhoneMast.currentRent;
        }
    }

    private void createTestDataWithRent() {
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithRent(20000f));
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithRent(10000f));
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithRent(32000f));
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithRent(16000f));
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithRent(9000f));
        mobilePhoneMastsDao.insert(MobilePhoneMastTestUtil.createWithRent(20000f));
    }
}
