package in.vaksys.vivekpk.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.extras.PercentLinearLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocumentFragment extends Fragment {

    private Button btnRegisterVehicle, btnContinue;
    private LinearLayout linearAddDrivingLicense, linearYourDrivingLicense, linearRegisterVehicle,
            linearVehicleDetails, linearVehicleDetailsListRaw;
    private PercentLinearLayout percentEnterCarDetails;

    private ImageView img_addGallery;

    public static DocumentFragment newInstance(int index) {
        DocumentFragment fragment = new DocumentFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_document, container, false);

        btnRegisterVehicle = (Button) rootView.findViewById(R.id.btn_registerVehicle);

        btnContinue = (Button) rootView.findViewById(R.id.btn_continue);

        img_addGallery = (ImageView) rootView.findViewById(R.id.img_addGallery);

        linearAddDrivingLicense = (LinearLayout) rootView.findViewById(R.id.linearAddDrivingLicense);
        linearYourDrivingLicense = (LinearLayout) rootView.findViewById(R.id.linearYourDrivingLicense);
        linearRegisterVehicle = (LinearLayout) rootView.findViewById(R.id.linearRegisterVehicle);
        linearVehicleDetails = (LinearLayout) rootView.findViewById(R.id.linearVehicleDetails);
        linearVehicleDetailsListRaw = (LinearLayout) rootView.findViewById(R.id.linearVehicleDeatilsListRaw);

        percentEnterCarDetails = (PercentLinearLayout) rootView.findViewById(R.id.percentEnterCarDetails);


        btnRegisterVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearAddDrivingLicense.setVisibility(View.GONE);
                linearYourDrivingLicense.setVisibility(View.GONE);
                linearRegisterVehicle.setVisibility(View.GONE);
                linearVehicleDetails.setVisibility(View.GONE);
                linearVehicleDetailsListRaw.setVisibility(View.GONE);

                percentEnterCarDetails.setVisibility(View.VISIBLE);
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearAddDrivingLicense.setVisibility(View.VISIBLE);
                linearYourDrivingLicense.setVisibility(View.GONE);
                linearRegisterVehicle.setVisibility(View.GONE);
                linearVehicleDetails.setVisibility(View.VISIBLE);
                linearVehicleDetailsListRaw.setVisibility(View.GONE);

                percentEnterCarDetails.setVisibility(View.GONE);
            }
        });

        img_addGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearAddDrivingLicense.setVisibility(View.GONE);
                linearYourDrivingLicense.setVisibility(View.VISIBLE);
                linearRegisterVehicle.setVisibility(View.GONE);
                linearVehicleDetails.setVisibility(View.GONE);
                linearVehicleDetailsListRaw.setVisibility(View.VISIBLE);

                percentEnterCarDetails.setVisibility(View.GONE);
            }
        });
        return rootView;
    }

}
