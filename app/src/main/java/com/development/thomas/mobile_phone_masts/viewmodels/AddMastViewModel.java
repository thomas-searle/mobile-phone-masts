package com.development.thomas.mobile_phone_masts.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import java.util.Date;

public class AddMastViewModel extends ViewModel {

    public ObservableField<String> propertyName;
    public ObservableField<String> propertyAddressOne;
    public ObservableField<String> propertyAddressTwo;
    public ObservableField<String> propertyAddressThree;
    public ObservableField<String> propertyAddressFour;
    public ObservableField<String> unitName;
    public ObservableField<String> tenantName;
    public ObservableField<String> leaseStartDate;
    public ObservableField<String> leaseEndDate;
    public ObservableField<String> leaseYears;
    public ObservableField<String> currentRent;

    public AddMastViewModel() {
        propertyName = new ObservableField<>();
        propertyAddressOne = new ObservableField<>();
        propertyAddressTwo = new ObservableField<>();
        propertyAddressThree = new ObservableField<>();
        propertyAddressFour = new ObservableField<>();
        unitName = new ObservableField<>();
        tenantName = new ObservableField<>();
        leaseStartDate = new ObservableField<>();
        leaseEndDate = new ObservableField<>();
        leaseYears = new ObservableField<>();
        currentRent = new ObservableField<>();
    }

}
