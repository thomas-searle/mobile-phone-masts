package com.development.thomas.mobile_phone_masts.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import dagger.Lazy;

public class ViewModelFactory<T extends ViewModel> implements ViewModelProvider.Factory {

    private Lazy<T> viewModel;

    @Inject
    public ViewModelFactory(Lazy<T> viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)viewModel.get();
    }
}
