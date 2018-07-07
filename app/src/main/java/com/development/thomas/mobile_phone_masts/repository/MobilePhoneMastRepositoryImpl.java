package com.development.thomas.mobile_phone_masts.repository;

import android.arch.lifecycle.LiveData;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.csv.MobilePhoneMastCSVReader;
import com.development.thomas.mobile_phone_masts.database.dao.MobilePhoneMastsDao;
import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MobilePhoneMastRepositoryImpl implements MobilePhoneMastRepository {

    private final int numberOfMastsToRetrieve = 5;
    private final String csvFilename = "mobile_phone_masts.csv";

    private MobilePhoneMastCSVReader mobilePhoneMastCSVReader;

    private MobilePhoneMastsDao mobilePhoneMastsDao;

    private MobilePhoneMastsApplication mobilePhoneMastsApplication;

    @Inject
    public MobilePhoneMastRepositoryImpl(MobilePhoneMastCSVReader mobilePhoneMastCSVReader,
                                         MobilePhoneMastsDao mobilePhoneMastsDao,
                                         MobilePhoneMastsApplication mobilePhoneMastsApplication) {
        this.mobilePhoneMastCSVReader = mobilePhoneMastCSVReader;
        this.mobilePhoneMastsDao = mobilePhoneMastsDao;
        this.mobilePhoneMastsApplication = mobilePhoneMastsApplication;
    }

    @Override
    public List<MobilePhoneMast> getTopMobilePhoneMasts(boolean ascending) {

        List<MobilePhoneMast> mobilePhoneMasts = new ArrayList<>();

        try {

            if (mobilePhoneMastsDao.rowsOfData() == 0) {
                // Load from CSV
                mobilePhoneMasts = mobilePhoneMastCSVReader.readMobilePhoneMasts(mobilePhoneMastsApplication.getAssets().open(csvFilename));

                for (MobilePhoneMast mobilePhoneMast: mobilePhoneMasts) {
                    mobilePhoneMastsDao.insert(mobilePhoneMast);
                }
            }

            if (ascending) {
                mobilePhoneMasts = mobilePhoneMastsDao.getMobilePhoneMastsAscending(numberOfMastsToRetrieve);
            } else {
                mobilePhoneMasts = mobilePhoneMastsDao.getMobilePhoneMastsDescending(numberOfMastsToRetrieve);
            }
        } catch (IOException | ParseException ex) {
            // TODO: Handle error
        }

        return mobilePhoneMasts;
    }
}
