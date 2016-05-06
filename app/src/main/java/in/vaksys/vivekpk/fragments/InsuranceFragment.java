package in.vaksys.vivekpk.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

import in.vaksys.vivekpk.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsuranceFragment extends Fragment {

    private TextView tvDate;

    private DatePickerDialog fromDatePickerDialog;

    private SimpleDateFormat dateFormatter;
    private String SelectedDate;
    public static final String TAG = "DATE";

    private Spinner spInsuranceCompany;

    public InsuranceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_insurance, container, false);

        tvDate = (TextView) rootView.findViewById(R.id.tv_date);

        spInsuranceCompany = (Spinner) rootView.findViewById(R.id.sp_insuranceCompany);

        List<String> CompanyName = new ArrayList<String>();
        CompanyName.add("Select Company");
        CompanyName.add("Business Services");
        CompanyName.add("Computers");
        CompanyName.add("Education");
        CompanyName.add("Personal");
        CompanyName.add("Travel");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, CompanyName);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spInsuranceCompany.setAdapter(dataAdapter);
        spInsuranceCompany.setSelection(0);

        setDateTimeField();

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);


        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectfromDate();
            }

            /*@Override
            public boolean onTouch(View v, MotionEvent event) {
                SelectfromDate();
                return true;
            }
*/
        });


        return rootView;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    Calendar c = Calendar.getInstance();

    private void SelectfromDate() {
        String formattedDate = sdf.format(c.getTime()); // current date
        Date d = null;
        try {
            d = sdf.parse(formattedDate);
        } catch (ParseException e) {
            Log.e(TAG, "SelectfromDate: " + e);
        }
        fromDatePickerDialog.getDatePicker().setMinDate(d.getTime());
        fromDatePickerDialog.show();
    }

    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SelectedDate = dateFormatter.format(newDate.getTime());
                tvDate.setText(SelectedDate);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

}
