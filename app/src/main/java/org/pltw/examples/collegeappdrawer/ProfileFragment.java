package org.pltw.examples.collegeappdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mrisk on 12/2/2016.
 */
public class ProfileFragment extends Fragment {

    Profile member1 = new Profile();
    TextView fName, lName;
    EditText editFName, editLName;
    Button update;
    Button dob;
    Date date = new Date();
    private static final int REQUEST_DATE_OF_BIRTH = 0;
    private static final int WITHIN_8_YEARS = 2008;
    private static final String TAG = "ProfileFragment";
    private SimpleDateFormat formatter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        member1.setfName("Ada");
        member1.setlName("Lovelace");
        member1.setDate(date);
        formatter = new SimpleDateFormat("MM/dd/yyyy");

        fName = (TextView) rootView.findViewById(R.id.profile_f_name);
        lName = (TextView) rootView.findViewById(R.id.profile_l_name);
        editFName = (EditText) rootView.findViewById(R.id.profile_edit_fname);
        editLName = (EditText) rootView.findViewById(R.id.profile_edit_lname);
        update = (Button) rootView.findViewById(R.id.profile_update);
        dob = (Button) rootView.findViewById(R.id.dob);

        fName.setText("First Name: " + member1.getfName() + member1.getDate().toString());
        lName.setText("Last Name: " + member1.getlName());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editFName.getText().length() >0){
                    fName.setText(editFName.getText());
                }
                if(editLName.getText().length() >0){
                    lName.setText(editLName.getText());
                }
            }
        });
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                //DatePickerFragment dialog = new DatePickerFragment();
                //System.out.print("line67");
                DatePickerFragment dialog = DatePickerFragment.newInstance(member1.getDate());
                dialog.setTargetFragment(dialog.getTargetFragment(), REQUEST_DATE_OF_BIRTH);

                dialog.show(fm, "test");
            }
        });


        dob.setText(formatter.format(member1.getDate()));
        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_DATE_OF_BIRTH) {
            Date date = (Date)data.getSerializableExtra(DatePickerFragment.EXTRA_DATE_OF_BIRTH);
            member1.setDate(date);
            dob.setText(formatter.format(member1.getDate()));
                }

    }

}
