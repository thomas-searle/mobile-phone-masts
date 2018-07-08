package com.development.thomas.mobile_phone_masts.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.R;
import com.development.thomas.mobile_phone_masts.repository.MobilePhoneMastRepositoryImpl;

import javax.inject.Inject;

public class AddMobileMastFragment extends Fragment {

    @Inject
    public MobilePhoneMastRepositoryImpl mobilePhoneMastRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MobilePhoneMastsApplication)getActivity().getApplication()).getApplicationComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_mast_fragment, container,false);
    }

}
