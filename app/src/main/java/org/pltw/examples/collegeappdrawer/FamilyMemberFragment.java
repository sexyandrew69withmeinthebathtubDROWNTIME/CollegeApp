package org.pltw.examples.collegeappdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mrisk on 12/2/2016.
 */
public class FamilyMemberFragment extends android.support.v4.app.Fragment {

    FamilyMember member1 = new FamilyMember();
    TextView fName;
    TextView lName;
    EditText editFName;
    EditText editLName;
    Button update;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_family_member, container, false);

        member1.setFname("Dad");
        member1.setLname("McFather");

        fName = (TextView) rootView.findViewById(R.id.family_f_name);
        lName = (TextView) rootView.findViewById(R.id.family_l_name);
        editFName = (EditText) rootView.findViewById(R.id.edit_f_name);
        editLName = (EditText) rootView.findViewById(R.id.edit_l_name);
        update = (Button) rootView.findViewById(R.id.update_button);

        fName.setText("First Name: " + member1.getFname());
        lName.setText("Last Name: " + member1.getLname());

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

        return rootView;



    }
}
