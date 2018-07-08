package com.development.thomas.mobile_phone_masts.fragments;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.R;
import com.development.thomas.mobile_phone_masts.databinding.AddMastFragmentBinding;
import com.development.thomas.mobile_phone_masts.dialogs.DatePickerDialogFragment;
import com.development.thomas.mobile_phone_masts.repository.MobilePhoneMastRepositoryImpl;
import com.development.thomas.mobile_phone_masts.viewmodels.AddMastViewModel;
import com.development.thomas.mobile_phone_masts.viewmodels.ViewModelFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.inject.Inject;

public class AddMobileMastFragment extends Fragment {

    @Inject
    public MobilePhoneMastRepositoryImpl mobilePhoneMastRepository;

    @Inject
    ViewModelFactory<AddMastViewModel> viewModelFactory;

    private AddMastFragmentBinding binding;
    private AddMastViewModel viewModel;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private InputMethodManager inputMethodManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MobilePhoneMastsApplication)getActivity().getApplication()).getApplicationComponent().inject(this);

        inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.add_mast_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set View Model
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddMastViewModel.class);
        binding.setViewModel(viewModel);

        binding.btnAddMast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    // TODO: Save to DB
                    Log.d("TEST", "ViewModel: " + binding.txtPropertyAddressOne.getText());
                }
            }
        });

        binding.txtLeaseEndDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    // Ensure soft keyboard is hidden
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
                    datePickerDialogFragment.setDatePickerDialogFragmentListener(new DatePickerDialogFragment.DatePickerDialogFragmentListener() {
                        @Override
                        public void onDateSet(int year, int month, int day) {
                            binding.txtLeaseEndDate.setText(dateFormat.format(new GregorianCalendar(year, month, day).getTime()));
                        }
                    });
                    datePickerDialogFragment.show(getActivity().getSupportFragmentManager(), "date-picker");
                }
            }
        });

        binding.txtLeaseStartDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    // Ensure soft keyboard is hidden
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
                    datePickerDialogFragment.setDatePickerDialogFragmentListener(new DatePickerDialogFragment.DatePickerDialogFragmentListener() {
                        @Override
                        public void onDateSet(int year, int month, int day) {
                            binding.txtLeaseStartDate.setText(dateFormat.format(new GregorianCalendar(year, month, day).getTime()));
                        }
                    });
                    datePickerDialogFragment.show(getActivity().getSupportFragmentManager(), "date-picker");
                }
            }
        });
    }

    private boolean validateForm() {
        if (!validateEditText(binding.txtPropertyAddressOne)) {
            return false;
        }

        if (!validateEditText(binding.txtPropertyAddressTwo)) {
            return false;
        }

        if (!validateEditText(binding.txtPropertyAddressThree)) {
            return false;
        }

        if (!validateEditText(binding.txtPropertyAddressFour)) {
            return false;
        }

        if (!validateEditText(binding.txtUnitName)) {
            return false;
        }

        if (!validateEditText(binding.txtTenantName)) {
            return false;
        }

        if (!validateEditText(binding.txtLeaseStartDate)) {
            return false;
        }

        if (!validateEditText(binding.txtLeaseEndDate)) {
            return false;
        }

        if (!validateEditText(binding.txtLeaseYears)) {
            return false;
        }

        if (!validateEditText(binding.txtCurrentRent)) {
            return false;
        }

        return true;
    }

    private boolean validateEditText(EditText editText) {
        if (TextUtils.isEmpty(editText.getText())) {
            editText.setError(getString(R.string.error_add_mast));
            return false;
        }

        return true;
    }
}
