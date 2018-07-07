package com.development.thomas.mobile_phone_masts.database;

import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import java.util.Date;

public class MobilePhoneMastTestUtil {

    public static MobilePhoneMast createWithDefaults() {
        MobilePhoneMast mobilePhoneMast = new MobilePhoneMast();
        mobilePhoneMast.currentRent = 0f;
        mobilePhoneMast.leaseEndDate = new Date();
        mobilePhoneMast.leaseStartDate = new Date();
        mobilePhoneMast.leaseYears = 1;
        mobilePhoneMast.propertyAddressOne = "";
        mobilePhoneMast.propertyAddressTwo = "";
        mobilePhoneMast.propertyAddressThree = "";
        mobilePhoneMast.propertyAddressFour = "";
        mobilePhoneMast.propertyName = "";
        mobilePhoneMast.tenantName = "";
        mobilePhoneMast.unitName = "";

        return mobilePhoneMast;
    }

    public static MobilePhoneMast createWithRent(float rent) {
        MobilePhoneMast mobilePhoneMast = createWithDefaults();
        mobilePhoneMast.currentRent = rent;
        return mobilePhoneMast;
    }
}
