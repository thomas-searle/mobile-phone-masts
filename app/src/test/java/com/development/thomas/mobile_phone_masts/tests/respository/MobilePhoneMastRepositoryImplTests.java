package com.development.thomas.mobile_phone_masts.tests.respository;

import android.content.res.AssetManager;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.csv.MobilePhoneMastCSVReader;
import com.development.thomas.mobile_phone_masts.dagger.DaggerRepositoryTestComponent;
import com.development.thomas.mobile_phone_masts.dagger.RepositoryTestComponent;
import com.development.thomas.mobile_phone_masts.database.dao.MobilePhoneMastsDao;
import com.development.thomas.mobile_phone_masts.repository.MobilePhoneMastRepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import javax.inject.Inject;

public class MobilePhoneMastRepositoryImplTests {

    @Inject
    public MobilePhoneMastCSVReader mobilePhoneMastCSVReader;

    @Inject
    public MobilePhoneMastsDao mobilePhoneMastsDao;

    @Inject
    public MobilePhoneMastsApplication mobilePhoneMastsApplication;

    @Inject
    public MobilePhoneMastRepositoryImpl mobilePhoneMastRepositoryImpl;

    private AssetManager assetManager;

    @Before
    public void setup() throws IOException {
        RepositoryTestComponent repositoryTestComponent = DaggerRepositoryTestComponent.builder().build();
        repositoryTestComponent.inject(this);

        assetManager = Mockito.mock(AssetManager.class);
        Mockito.when(assetManager.open(Mockito.anyString())).thenReturn(Mockito.mock(InputStream.class));
    }

    @Test
    public void testGetAscendingTopMobilePhoneMastsShouldImport() throws IOException, ParseException {

        Mockito.when(mobilePhoneMastsDao.rowsOfData()).thenReturn(0);
        Mockito.when(mobilePhoneMastsApplication.getAssets()).thenReturn(assetManager);

        mobilePhoneMastRepositoryImpl.getTopMobilePhoneMasts(true);

        Mockito.verify(mobilePhoneMastsDao, Mockito.times(1)).rowsOfData();
        Mockito.verify(mobilePhoneMastCSVReader, Mockito.times(1)).readMobilePhoneMasts(Mockito.any(InputStream.class));

        // Ascending should be called once
        Mockito.verify(mobilePhoneMastsDao, Mockito.times(1)).getMobilePhoneMastsAscending(5);

        // Descending should not be called
        Mockito.verify(mobilePhoneMastsDao, Mockito.times(0)).getMobilePhoneMastsDescending(5);
    }

    @Test
    public void testGetDescendingTopMobilePhoneMastsShouldImport() throws IOException, ParseException {

        Mockito.when(mobilePhoneMastsDao.rowsOfData()).thenReturn(0);
        Mockito.when(mobilePhoneMastsApplication.getAssets()).thenReturn(assetManager);

        mobilePhoneMastRepositoryImpl.getTopMobilePhoneMasts(false);

        Mockito.verify(mobilePhoneMastsDao, Mockito.times(1)).rowsOfData();
        Mockito.verify(mobilePhoneMastCSVReader, Mockito.times(1)).readMobilePhoneMasts(Mockito.any(InputStream.class));

        // Ascending should not be called
        Mockito.verify(mobilePhoneMastsDao, Mockito.times(0)).getMobilePhoneMastsAscending(5);

        // Descending should be called once
        Mockito.verify(mobilePhoneMastsDao, Mockito.times(1)).getMobilePhoneMastsDescending(5);
    }

}
