package in.vaksys.vivekpk.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maksim88.passwordedittext.PasswordEditText;

import java.util.LinkedHashMap;
import java.util.Map;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.extras.Validator;

/**
 * Created by dell980 on 5/2/2016.
 */
public class SigninFragment extends Fragment {

    private static final String TAG = "Vivekpk" + SigninFragment.class.getSimpleName();

    private EditText etPhoneNo;
    private PasswordEditText etPassword;
    private TextView tvErrorPhoneNo, tvErrorPassword;
    private Button btnSignIn;
    boolean isFormValid = true;

    String phoneErrorMsg = "kindly enter your phone no. It is mandatory ";
    String passwordErrorMsg = "Kindly check your phone no or password";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        etPhoneNo = (EditText) rootView.findViewById(R.id.et_phoneNo);
        etPassword = (PasswordEditText) rootView.findViewById(R.id.et_password);
        tvErrorPhoneNo = (TextView) rootView.findViewById(R.id.tv_errorPhoneNo);
        tvErrorPassword = (TextView) rootView.findViewById(R.id.tv_errorPassword);
        btnSignIn = (Button) rootView.findViewById(R.id.btn_signin);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        return rootView;
    }

    private void submitForm() {

        final Map<String, String> formParams = new LinkedHashMap<>();
        formParams.put("phoneno", etPhoneNo.getText().toString());
        formParams.put("password", etPassword.getText().toString());

        if (isFromParamValid(formParams)) {
            Toast.makeText(getActivity(), "Sign in", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isFromParamValid(Map<String, String> formParams) {

        Log.i(TAG, "inside is form param valid");

        isFormValid = true;

        Validator.validatePhoneNo(formParams.get("phoneno"), new Validator.ValidationListener() {
            @Override
            public void validationFailed(String msg) {
                tvErrorPhoneNo.setVisibility(View.VISIBLE);
                tvErrorPhoneNo.setText(phoneErrorMsg);
                isFormValid = false;
            }
        });

        Validator.validatePassword(formParams.get("password"), new Validator.ValidationListener() {
            @Override
            public void validationFailed(String msg) {
                tvErrorPassword.setVisibility(View.VISIBLE);
                tvErrorPassword.setText(passwordErrorMsg);
                isFormValid = false;
            }
        });

        return isFormValid;
    }

}
