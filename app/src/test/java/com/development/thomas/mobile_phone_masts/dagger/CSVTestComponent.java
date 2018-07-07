package com.development.thomas.mobile_phone_masts.dagger;

import com.development.thomas.mobile_phone_masts.dagger.modules.TestApplicationModule;
import com.development.thomas.mobile_phone_masts.dagger.modules.TestCSVModule;
import com.development.thomas.mobile_phone_masts.dagger.modules.TestDatabaseModule;
import com.development.thomas.mobile_phone_masts.tests.csv.MobilePhoneMastCSVReaderTests;
import com.development.thomas.mobile_phone_masts.tests.respository.MobilePhoneMastRepositoryImplTests;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestCSVModule.class, TestDatabaseModule.class, TestApplicationModule.class})
public interface CSVTestComponent {

    void inject(MobilePhoneMastCSVReaderTests mobilePhoneMastCSVReaderTests);
}
