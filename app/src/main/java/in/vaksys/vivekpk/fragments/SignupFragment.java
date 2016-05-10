package in.vaksys.vivekpk.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.activities.VerifyOtpActivity;
import in.vaksys.vivekpk.adapter.ListViewAdapter;
import in.vaksys.vivekpk.extras.AdapterCallback;
import in.vaksys.vivekpk.extras.MyApplication;
import in.vaksys.vivekpk.pojo.Coutrycode;

/**
 * Created by dell980 on 5/2/2016.
 */
public class SignupFragment extends Fragment implements AdapterCallback {

    EditText etCountryCode;
    private Button btnContinue;
    /*private String[] code = {"(+36)", "(+354)", "(+91)", "(+62)", "(+62)",
            "(+98)", "(+98)", "(+964)"};

    private String[] countryName = {"Hungary", "Iceland", "India", "Indonesia", "Iran",
            "Iran", "Iran", "Iran"};

    CountryCodeAdapter adapter;
    ArrayList<Country> arraylist = new ArrayList<Country>();

    ListView list;
    EditText editsearch;*/
    Dialog dialog;

    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] code;
    String[] countryName;
    ArrayList<Coutrycode> arraylist = new ArrayList<Coutrycode>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        dialog = new Dialog(getContext());

        code = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        countryName = new String[]{"China", "India", "United States",
                "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
                "Russia", "Japan"};

        etCountryCode = (EditText) rootView.findViewById(R.id.et_code);

        btnContinue = (Button) rootView.findViewById(R.id.btn_continue);

        etCountryCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAlertDialogWithListview();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog confirm = new Dialog(getActivity());
                confirm.requestWindowFeature(Window.FEATURE_NO_TITLE);
                confirm.setContentView(R.layout.confirm_dialog);


                Button btnSend = (Button) confirm.findViewById(R.id.btn_send);

                btnSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), VerifyOtpActivity.class));
                    }
                });

                confirm.show();
            }
        });

        return rootView;
    }


    public void ShowAlertDialogWithListview() {
        dialog.setTitle("Choose country Code");
        dialog.setContentView(R.layout.country_list);


        list = (ListView) dialog.findViewById(R.id.list);

        for (int i = 0; i < countryName.length; i++) {
            Coutrycode wp = new Coutrycode(code[i], countryName[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

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

        dialog.show();
    }


    @Override
    public void onMethodCallback() {
        dialog.dismiss();
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences("harsh", Context.MODE_PRIVATE);
        //Toast.makeText(MyApplication.getInstance(), "yeyyyyy" + sharedPreferences.getString("value", "fuck"), Toast.LENGTH_LONG).show();
        etCountryCode.setText(sharedPreferences.getString("value", ""));
    }
}
