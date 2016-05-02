package in.vaksys.vivekpk.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import in.vaksys.vivekpk.R;

/**
 * Created by dell980 on 5/2/2016.
 */
public class SignupFragment extends Fragment {

    EditText etCountryCode;
    private String TitleName[]={"Sunil Gupta","Ram Chnadra"," Abhishek Tripathi","Amit Verma","Sandeep Pal","Awadhesh Diwakar","Shishir Verma","Ravi Vimal","Prabhakr Singh","Manish Srivastva","Jitendra Singh","Surendra Pal"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        etCountryCode = (EditText) rootView.findViewById(R.id.et_code);



        return rootView;
    }
}
