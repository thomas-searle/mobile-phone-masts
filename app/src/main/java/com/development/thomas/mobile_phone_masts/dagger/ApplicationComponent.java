package com.development.thomas.mobile_phone_masts.dagger;

import com.development.thomas.mobile_phone_masts.csv.MobilePhoneMastCSVReader;
import com.development.thomas.mobile_phone_masts.dagger.modules.ApplicationModule;
import com.development.thomas.mobile_phone_masts.dagger.modules.CSVModule;
import com.development.thomas.mobile_phone_masts.dagger.modules.DatabaseModule;
import com.development.thomas.mobile_phone_masts.fragments.HomeFragment;
import com.development.thomas.mobile_phone_masts.repository.MobilePhoneMastRepositoryImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, CSVModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject (MobilePhoneMastRepositoryImpl mobilePhoneMastRepositoryImpl);

    void inject(MobilePhoneMastCSVReader mobilePhoneMastCSVReader);

    // Fragments
    void inject(HomeFragment fragment);
}
