package in.vaksys.vivekpk.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.maksim88.passwordedittext.PasswordEditText;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.activities.VerifyOtpActivity;
import in.vaksys.vivekpk.adapter.CountryCodeAdapter;
import in.vaksys.vivekpk.pojo.Country;

/**
 * Created by dell980 on 5/2/2016.
 */
public class SignupFragment extends Fragment {

    @Bind(R.id.et_firstName)
    EditText etFirstName;
    @Bind(R.id.et_lasttName)
    EditText etLasttName;
    @Bind(R.id.et_emailId)
    EditText etEmailId;
    @Bind(R.id.et_code_signup)
    EditText etCode;
    @Bind(R.id.et_contactNo)
    EditText etContactNo;
    @Bind(R.id.et_password)
    PasswordEditText etPassword;
    @Bind(R.id.btn_continue)
    Button btnContinue;
    private String[] code = {"(+36)", "(+354)", "(+91)", "(+62)", "(+62)",
            "(+98)", "(+98)", "(+964)"};

    private String[] countryName = {"Hungary", "Iceland", "India", "Indonesia", "Iran",
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
        ButterKnife.bind(this, rootView);

        etCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAlertDialogWithListview();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
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
                etCode.setText(parent.getSelectedItem().toString());
            }
        });
        dialog.show();
    }

    private void submitForm() {
        if (!validateFirstName()) {
            return;
        }
        if (!validateLastName()) {
            return;
        }
        if (!validateEmail()) {
            return;
        }
        if (!validateCode()) {
            return;
        }
        if (!validateNumber()) {
            return;
        }
        if (!validatePassword()) {
            return;
        }
        /*getData();
        uploadData();*/
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private boolean validateFirstName() {
        if (etFirstName.getText().toString().trim().isEmpty()) {
            etFirstName.setError(getString(R.string.err_msg_first_name));
            requestFocus(etFirstName);
            return false;
        } else {
            return true;
        }
    }

    private boolean validateLastName() {
        if (etLasttName.getText().toString().trim().isEmpty()) {
            etLasttName.setError(getString(R.string.err_msg_last_name));
            requestFocus(etLasttName);
            return false;
        } else {
            return true;
        }
    }

    private boolean validateEmail() {
        String email = etEmailId.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            etEmailId.setError(getString(R.string.err_msg_email));
            requestFocus(etEmailId);
            return false;
        } else {
            return true;
        }
    }

    private boolean validateCode() {

        if (etCode.getText().toString().trim().isEmpty()) {
            etCode.setError(getString(R.string.err_msg_code));
            requestFocus(etCode);
            return false;
        } else {
            return true;
        }
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validateNumber() {
        if (etContactNo.getText().toString().trim().isEmpty()) {
            etContactNo.setError(getString(R.string.err_msg_number));
            requestFocus(etContactNo);
            return false;
        }
        if (etContactNo.length() != 10) {
            etContactNo.setError(getString(R.string.err_msg_valid_number));
            requestFocus(etContactNo);
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword() {
        if (etPassword.getText().toString().trim().isEmpty()) {
            etPassword.setError(getString(R.string.err_msg_password));
            requestFocus(etPassword);
            return false;
        }
        if (etPassword.length() < 6) {
            etPassword.setError(getString(R.string.err_valid_password));
            requestFocus(etPassword);
            return false;
        } else {
            return true;
        }
    }
}
