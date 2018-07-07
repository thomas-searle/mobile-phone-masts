package com.development.thomas.mobile_phone_masts.tests.csv;

import com.development.thomas.mobile_phone_masts.csv.CSVReader;
import com.development.thomas.mobile_phone_masts.csv.MobilePhoneMastCSVReader;
import com.development.thomas.mobile_phone_masts.dagger.CSVTestComponent;
import com.development.thomas.mobile_phone_masts.dagger.DaggerCSVTestComponent;
import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import static org.mockito.Mockito.when;

public class MobilePhoneMastCSVReaderTests {

    @Inject
    CSVReader csvReader;

    @Inject
    MobilePhoneMastCSVReader mobilePhoneMastCSVReader;

    @Before
    public void setup() {
        CSVTestComponent CSVTestComponent = DaggerCSVTestComponent.builder().build();
        CSVTestComponent.inject(this);
    }

    @Test
    public void testReadMobilePhoneMasts() throws IOException, ParseException {
        List<String[]> exampleCsvDataRows = new ArrayList<>();
        exampleCsvDataRows.add(new String[] {"Beecroft Hill", "Broad Lane", "", "", "LS13", "Beecroft Hill - Telecom App", "Arqiva Services ltd", "01 Mar 1994", "28 Feb 2058", "64", "23950"});
        exampleCsvDataRows.add(new String[] {"Queenswood Heights", "Queenswood Heights", "Queenswood Gardens", "Headingley", "Leeds", "Queenswood Hgt-Telecom App.", "Vodafone Ltd", "08 Nov 2004", "07 Nov 2029", "25", "9500"});
        when(csvReader.readCSV(Mockito.any(InputStream.class), Mockito.anyBoolean(), Mockito.anyString())).thenReturn(exampleCsvDataRows);

        List<MobilePhoneMast> mobilePhoneMasts = mobilePhoneMastCSVReader.readMobilePhoneMasts(Mockito.mock(InputStream.class));

        Assert.assertNotNull(mobilePhoneMasts);
        Assert.assertEquals(2, mobilePhoneMasts.size());

        Assert.assertEquals("Beecroft Hill", mobilePhoneMasts.get(0).propertyName);
        Assert.assertEquals("Broad Lane", mobilePhoneMasts.get(0).propertyAddressOne);
        Assert.assertEquals("", mobilePhoneMasts.get(0).propertyAddressTwo);
        Assert.assertEquals("", mobilePhoneMasts.get(0).propertyAddressThree);
        Assert.assertEquals("LS13", mobilePhoneMasts.get(0).propertyAddressFour);
        Assert.assertEquals("Beecroft Hill - Telecom App", mobilePhoneMasts.get(0).unitName);
        Assert.assertEquals("Arqiva Services ltd", mobilePhoneMasts.get(0).tenantName);
        Assert.assertEquals(new GregorianCalendar(1994, 2, 1).getTime(), mobilePhoneMasts.get(0).leaseStartDate);
        Assert.assertEquals(new GregorianCalendar(2058, 1, 28).getTime(), mobilePhoneMasts.get(0).leaseEndDate);
        Assert.assertEquals(64, mobilePhoneMasts.get(0).leaseYears);
        Assert.assertEquals(23950f, mobilePhoneMasts.get(0).currentRent);

        Assert.assertEquals("Queenswood Heights", mobilePhoneMasts.get(1).propertyName);
        Assert.assertEquals("Queenswood Heights", mobilePhoneMasts.get(1).propertyAddressOne);
        Assert.assertEquals("Queenswood Gardens", mobilePhoneMasts.get(1).propertyAddressTwo);
        Assert.assertEquals("Headingley", mobilePhoneMasts.get(1).propertyAddressThree);
        Assert.assertEquals("Leeds", mobilePhoneMasts.get(1).propertyAddressFour);
        Assert.assertEquals("Queenswood Hgt-Telecom App.", mobilePhoneMasts.get(1).unitName);
        Assert.assertEquals("Vodafone Ltd", mobilePhoneMasts.get(1).tenantName);
        Assert.assertEquals(new GregorianCalendar(2004, 10, 8).getTime(), mobilePhoneMasts.get(1).leaseStartDate);
        Assert.assertEquals(new GregorianCalendar(2029, 10, 7).getTime(), mobilePhoneMasts.get(1).leaseEndDate);
        Assert.assertEquals(25, mobilePhoneMasts.get(1).leaseYears);
        Assert.assertEquals(9500f, mobilePhoneMasts.get(1).currentRent);
    }
}
