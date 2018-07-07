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

}
