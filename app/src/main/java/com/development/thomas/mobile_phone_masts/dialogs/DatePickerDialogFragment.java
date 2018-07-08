package com.development.thomas.mobile_phone_masts.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerDialogFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public interface DatePickerDialogFragmentListener {
        void onDateSet ( int year, int month, int day);
    }

    private DatePickerDialogFragmentListener datePickerDialogFragmentListener;

    public void setDatePickerDialogFragmentListener(DatePickerDialogFragmentListener listener) {
        datePickerDialogFragmentListener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        datePickerDialogFragmentListener.onDateSet(year, month, day);
    }
}
