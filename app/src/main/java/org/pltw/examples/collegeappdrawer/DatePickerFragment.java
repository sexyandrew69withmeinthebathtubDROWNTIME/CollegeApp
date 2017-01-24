package org.pltw.examples.collegeappdrawer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mrisk on 1/13/2017.
 */
public class DatePickerFragment extends android.support.v4.app.DialogFragment {
    static String DATE_ARGUMENT = "Date of Birth";
    String TAG = "lol";
    DatePicker datepicker;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.date_picker, null);


        Date date;
        date = (Date)getArguments().getSerializable(DATE_ARGUMENT);
        System.out.print(TAG + date);
        if(date == null) {
            System.out.print(TAG + date);
        } else {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);


            datepicker = (DatePicker) v.findViewById(R.id.dialog_date_of_birth);
            datepicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH), null);
        }

        return new AlertDialog.Builder(getActivity()).setView(v).setTitle("Date of Birth").setPositiveButton("Done", null).create();
    }

    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(DATE_ARGUMENT, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
