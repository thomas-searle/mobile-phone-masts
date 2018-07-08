package com.development.thomas.mobile_phone_masts.activities;

import android.os.Bundle;

import com.development.thomas.mobile_phone_masts.R;
import com.development.thomas.mobile_phone_masts.fragments.AddMobileMastFragment;

public class AddMastActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mast);

        AddMobileMastFragment addMobileMastFragment = new AddMobileMastFragment();
        displayFragment(addMobileMastFragment);
    }
}
