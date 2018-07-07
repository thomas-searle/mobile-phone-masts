package com.development.thomas.mobile_phone_masts.dagger.modules;

import com.development.thomas.mobile_phone_masts.csv.CSVReader;
import com.development.thomas.mobile_phone_masts.csv.MobilePhoneMastCSVReader;
import com.development.thomas.mobile_phone_masts.dagger.modules.CSVModule;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestCSVModule {

    @Provides
    @Singleton
    public CSVReader provideCSVReader() {
        return Mockito.mock(CSVReader.class);
    }

    @Provides
    @Singleton
    public MobilePhoneMastCSVReader provideMobilePhoneMastCSVReader(CSVReader csvReader) {
        return new MobilePhoneMastCSVReader(csvReader);
    }
}
