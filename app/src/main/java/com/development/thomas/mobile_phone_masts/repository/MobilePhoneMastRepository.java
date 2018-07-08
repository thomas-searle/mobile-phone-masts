package com.development.thomas.mobile_phone_masts.repository;

import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import java.util.List;

public interface MobilePhoneMastRepository {

    /**
     * Retrieve the top 5 mobile phone masts based on lease amount
     * @param ascending If true ordered by ascending lease amount, descending otherwise
     * @return
     */
    List<MobilePhoneMast> getTopMobilePhoneMasts(boolean ascending);

    /**
     * Saves a Mobile Phone Mast
     * @param propertyAddressOne
     * @param propertyAddressTwo
     * @param propertyAddressThree
     * @param propertyAddressFour
     * @param unitName
     * @param tenantName
     * @param leaseStartDate
     * @param leaseEndDate
     * @param leaseYears
     * @param currentRent
     */
    void insertMobilePhoneMast(String propertyName,
                               String propertyAddressOne,
                               String propertyAddressTwo,
                               String propertyAddressThree,
                               String propertyAddressFour,
                               String unitName,
                               String tenantName,
                               String leaseStartDate,
                               String leaseEndDate,
                               int leaseYears,
                               float currentRent);

}
