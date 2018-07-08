package com.development.thomas.mobile_phone_masts.tableview;

import android.content.Context;
import android.util.AttributeSet;

import com.development.thomas.mobile_phone_masts.R;
import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnDpWidthModel;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders;

public class MobileMastTableView extends TableView<MobilePhoneMast> {
    public MobileMastTableView(Context context) {
        super(context);
        initialise();
    }

    public MobileMastTableView(Context context, AttributeSet attributes) {
        super(context, attributes);
        initialise();
    }

    public MobileMastTableView(Context context, AttributeSet attributes, int styleAttributes) {
        super(context, attributes, styleAttributes);
        initialise();
    }

    public void initialise() {
        // Set column count
        int columnCount = getResources().getStringArray(R.array.mast_table_header_row).length;
        this.setColumnCount(columnCount);

        //Setup header row
        this.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), getResources().getStringArray(R.array.mast_table_header_row)));

        // Set column widths
        TableColumnDpWidthModel tableColumnDpWidthModel = new TableColumnDpWidthModel(getContext(), columnCount, 100);
        // Property Name
        tableColumnDpWidthModel.setColumnWidth(0, 300);
        // Property Address One
        tableColumnDpWidthModel.setColumnWidth(1, 300);
        // Property Address Two
        tableColumnDpWidthModel.setColumnWidth(2, 300);
        // Property Address Three
        tableColumnDpWidthModel.setColumnWidth(3, 300);
        // Property Address Four
        tableColumnDpWidthModel.setColumnWidth(4, 200);
        // Unit Name
        tableColumnDpWidthModel.setColumnWidth(5, 300);
        //Tenant Name
        tableColumnDpWidthModel.setColumnWidth(6, 300);
        //Lease Start Date
        tableColumnDpWidthModel.setColumnWidth(7, 200);
        //Lease End Date
        tableColumnDpWidthModel.setColumnWidth(8, 200);
        //Lease Years
        tableColumnDpWidthModel.setColumnWidth(9, 200);
        //Current Rent
        tableColumnDpWidthModel.setColumnWidth(10, 200);
        this.setColumnModel(tableColumnDpWidthModel);

        // Alternate row color background
        int colorEvenRows = getResources().getColor(R.color.table_row_even);
        int colorOddRows = getResources().getColor(R.color.table_row_odd);
        this.setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(colorEvenRows, colorOddRows));
    }
}
