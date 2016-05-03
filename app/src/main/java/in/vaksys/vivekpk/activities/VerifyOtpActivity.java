package in.vaksys.vivekpk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import in.vaksys.vivekpk.R;

public class VerifyOtpActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText etOtp;
    private TextView tvResend,tvOtpError,tvVerified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
//        mToolbar.setLogo(R.drawable.ic_action_name1);

    }
}
