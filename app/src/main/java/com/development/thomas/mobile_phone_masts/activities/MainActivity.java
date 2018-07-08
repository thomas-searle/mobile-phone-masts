package com.development.thomas.mobile_phone_masts.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.development.thomas.mobile_phone_masts.R;
import com.development.thomas.mobile_phone_masts.fragments.AddMobileMastFragment;
import com.development.thomas.mobile_phone_masts.fragments.HomeFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = new HomeFragment();
        displayFragment(homeFragment);
    }

    public void onAddMobileMastInitiated() {
        Intent addMastIntent = new Intent(this, AddMastActivity.class);
        startActivity(addMastIntent);
    }
}
