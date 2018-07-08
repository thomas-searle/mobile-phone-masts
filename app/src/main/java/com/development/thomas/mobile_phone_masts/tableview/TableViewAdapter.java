package com.development.thomas.mobile_phone_masts.tableview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.development.thomas.mobile_phone_masts.database.entities.MobilePhoneMast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;

public class TableViewAdapter extends TableDataAdapter<MobilePhoneMast> {

    private int paddingLeft = 20;
    private int paddingTop = 15;
    private int paddingRight = 20;
    private int paddingBottom = 15;
    private int textSize = 18;
    private int typeface = Typeface.NORMAL;
    private int textColor = 0x99000000;

    public TableViewAdapter(Context context, List<MobilePhoneMast> data) {
        super(context, data);
    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        MobilePhoneMast mobilePhoneMast = getRowData(rowIndex);
        View renderedView = null;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex) {
            case 0:
                renderedView = renderCellView(mobilePhoneMast.propertyName, parentView);
                break;

            case 1:
                renderedView = renderCellView(mobilePhoneMast.propertyAddressOne, parentView);
                break;

            case 2:
                renderedView = renderCellView(mobilePhoneMast.propertyAddressTwo, parentView);
                break;

            case 3:
                renderedView = renderCellView(mobilePhoneMast.propertyAddressThree, parentView);
                break;

            case 4:
                renderedView = renderCellView(mobilePhoneMast.propertyAddressFour, parentView);
                break;

            case 5:
                renderedView = renderCellView(mobilePhoneMast.unitName, parentView);
                break;

            case 6:
                renderedView = renderCellView(mobilePhoneMast.tenantName, parentView);
                break;

            case 7:
                renderedView = renderCellView(dateFormat.format(mobilePhoneMast.leaseStartDate), parentView);
                break;

            case 8:
                renderedView = renderCellView(dateFormat.format(mobilePhoneMast.leaseEndDate), parentView);
                break;

            case 9:
                renderedView = renderCellView(String.valueOf(mobilePhoneMast.leaseYears), parentView);
                break;

            case 10:
                renderedView = renderCellView(String.valueOf(mobilePhoneMast.currentRent), parentView);
                break;

            default:
                renderedView = renderCellView(String.valueOf(mobilePhoneMast.currentRent), parentView);
                break;
        }

        return renderedView;
    }

    private View renderCellView(String text, ViewGroup parentView) {
        TextView textView = new TextView(getContext());
        textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        textView.setTypeface(textView.getTypeface(), typeface);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(text);


        return textView;
    }
}
