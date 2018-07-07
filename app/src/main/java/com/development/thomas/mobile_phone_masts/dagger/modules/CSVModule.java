package com.development.thomas.mobile_phone_masts.dagger.modules;

import com.development.thomas.mobile_phone_masts.csv.CSVReader;
import com.development.thomas.mobile_phone_masts.csv.MobilePhoneMastCSVReader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CSVModule {

    @Singleton
    @Provides
    public CSVReader provideCSVReader() {
        return new CSVReader();
    }

    @Singleton
    @Provides
    public MobilePhoneMastCSVReader provideMobilePhoneMastCSVReader(CSVReader csvReader) {
        return new MobilePhoneMastCSVReader(csvReader);
    }
}
