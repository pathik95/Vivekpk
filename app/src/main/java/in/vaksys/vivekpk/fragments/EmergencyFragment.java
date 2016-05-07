package in.vaksys.vivekpk.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import in.vaksys.vivekpk.R;

/**
 * Created by dell980 on 5/7/2016.
 */
public class EmergencyFragment extends Fragment {

    private Button btnContactOne;
    private LinearLayout linearLayoutOne;
    private ImageView deleteContactOne;

    public static EmergencyFragment newInstance(int index) {
        EmergencyFragment fragment = new EmergencyFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_emergency, container, false);

        btnContactOne = (Button) rootView.findViewById(R.id.btn_contactOne);
        linearLayoutOne = (LinearLayout) rootView.findViewById(R.id.linear_contactOne);
        deleteContactOne = (ImageView) rootView.findViewById(R.id.img_deleteContact);

        btnContactOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("emergencyFragment", "onClick: ");
                btnContactOne.setVisibility(View.GONE);
                linearLayoutOne.setVisibility(View.VISIBLE);
            }
        });

        deleteContactOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutOne.setVisibility(View.GONE);
                btnContactOne.setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }


}
