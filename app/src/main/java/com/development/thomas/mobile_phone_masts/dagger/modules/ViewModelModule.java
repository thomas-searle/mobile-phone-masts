package com.development.thomas.mobile_phone_masts.dagger.modules;

import com.development.thomas.mobile_phone_masts.viewmodels.AddMastViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    public AddMastViewModel provideAddMastViewModel() {
        return new AddMastViewModel();
    }

}
