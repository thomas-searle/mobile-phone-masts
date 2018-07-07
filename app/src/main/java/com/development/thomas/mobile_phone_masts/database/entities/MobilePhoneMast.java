package com.development.thomas.mobile_phone_masts.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class MobilePhoneMast {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "property_name")
    public String propertyName;

    @ColumnInfo(name = "property_address_one")
    public String propertyAddressOne;

    @ColumnInfo(name = "property_address_two")
    public String propertyAddressTwo;

    @ColumnInfo(name = "property_address_three")
    public String propertyAddressThree;

    @ColumnInfo(name = "property_address_four")
    public String propertyAddressFour;

    @ColumnInfo(name = "unit_name")
    public String unitName;

    @ColumnInfo(name = "tenant_name")
    public String tenantName;

    @ColumnInfo(name = "lease_start_date")
    public Date leaseStartDate;

    @ColumnInfo(name = "lease_end_date")
    public Date leaseEndDate;

    @ColumnInfo(name = "lease_years")
    public int leaseYears;

    @ColumnInfo(name = "current_rent")
    public float currentRent;
}
