package in.vaksys.vivekpk.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.adapter.CountryCodeAdapter;
import in.vaksys.vivekpk.pojo.Country;

/**
 * Created by dell980 on 5/2/2016.
 */
public class SignupFragment extends Fragment implements View.OnClickListener {

    EditText etCountryCode;
    private String[] code = {"(+36)", "(+354)", "(+91)", "(+62)", "(+62)",
            "(+98)", "(+98)", "(+964)"};

    private String[] countryName = {"Hungary", "(Iceland", "India", "Indonesia", "Iran",
            "Iran", "Iran", "Iran"};

    CountryCodeAdapter adapter;
    ArrayList<Country> arraylist = new ArrayList<Country>();

    ListView list;
    EditText editsearch;
    Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        etCountryCode = (EditText) rootView.findViewById(R.id.et_code);

        etCountryCode.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        ShowAlertDialogWithListview();
    }

    public void ShowAlertDialogWithListview() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.country_list);

        list = (ListView) dialog.findViewById(R.id.list);

        for (int i = 0; i < code.length; i++) {
            Country wp = new Country(code[i], countryName[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new CountryCodeAdapter(getActivity(), arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) dialog.findViewById(R.id.et_search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                etCountryCode.setText(parent.getSelectedItem().toString());
            }
        });
        dialog.show();
    }
}
