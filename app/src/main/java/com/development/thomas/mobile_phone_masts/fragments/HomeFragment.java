package com.development.thomas.mobile_phone_masts.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.R;
import com.development.thomas.mobile_phone_masts.repository.MobilePhoneMastRepositoryImpl;
import com.development.thomas.mobile_phone_masts.tableview.MobileMastTableView;
import com.development.thomas.mobile_phone_masts.tableview.TableViewAdapter;

import javax.inject.Inject;

public class HomeFragment extends Fragment {

    private boolean shouldAscend = false;

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
        return inflater.inflate(R.layout.home_fragment, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MobileMastTableView tableView = getView().findViewById(R.id.tableView);
        tableView.setDataAdapter(new TableViewAdapter(getContext(), mobilePhoneMastRepository.getTopMobilePhoneMasts(true)));

        Button toggleButton = getView().findViewById(R.id.btn_toggle_order);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableView.setDataAdapter(new TableViewAdapter(getContext(), mobilePhoneMastRepository.getTopMobilePhoneMasts(shouldAscend)));
                shouldAscend = !shouldAscend;
            }
        });
    }


}
