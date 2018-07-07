package com.development.thomas.mobile_phone_masts.csv;

import com.development.thomas.mobile_phone_masts.MobilePhoneMastsApplication;
import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MobilePhoneMastCSVReader {

    private final boolean skipFirstRow = true;
    private final String columnSplitBy = ",";

    private CSVReader csvReader;

    @Inject
    public MobilePhoneMastCSVReader(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public List<MobilePhoneMast> readMobilePhoneMasts(InputStream inputStream) throws IOException, ParseException {
        List<MobilePhoneMast> mobilePhoneMasts = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

        List<String[]> rows = csvReader.readCSV(inputStream, skipFirstRow, columnSplitBy);

        for (String[] row: rows) {
            MobilePhoneMast mobilePhoneMast = new MobilePhoneMast();
            mobilePhoneMast.propertyName = row[0];
            mobilePhoneMast.propertyAddressOne = row[1];
            mobilePhoneMast.propertyAddressTwo = row[2];
            mobilePhoneMast.propertyAddressThree = row[3];
            mobilePhoneMast.propertyAddressFour = row[4];
            mobilePhoneMast.unitName = row[5];
            mobilePhoneMast.tenantName = row[6];
            mobilePhoneMast.leaseStartDate = dateFormat.parse(row[7]);
            mobilePhoneMast.leaseEndDate = dateFormat.parse(row[8]);
            mobilePhoneMast.leaseYears = Integer.parseInt(row[9]);
            mobilePhoneMast.currentRent = Float.parseFloat(row[10]);

            mobilePhoneMasts.add(mobilePhoneMast);
        }

        return mobilePhoneMasts;
    }

}
