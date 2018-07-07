package com.development.thomas.mobile_phone_masts.dagger;

import com.development.thomas.mobile_phone_masts.dagger.modules.TestApplicationModule;
import com.development.thomas.mobile_phone_masts.dagger.modules.TestDatabaseModule;
import com.development.thomas.mobile_phone_masts.dagger.modules.TestRepositoryModule;
import com.development.thomas.mobile_phone_masts.tests.respository.MobilePhoneMastRepositoryImplTests;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestRepositoryModule.class, TestDatabaseModule.class, TestApplicationModule.class})
public interface RepositoryTestComponent {
    void inject(MobilePhoneMastRepositoryImplTests mobilePhoneMastRepositoryImplTests);
}
