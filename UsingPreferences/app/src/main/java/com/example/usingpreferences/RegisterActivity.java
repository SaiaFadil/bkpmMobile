package com.example.usingpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText mViewUser, mViewPassword, mViewPassword2;
    private Button mBtnRegister;
    private TextView mTextLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mViewUser = findViewById(R.id.et_emailSignup);
        mViewPassword = findViewById(R.id.et_passwordSignup);
        mViewPassword2 = findViewById(R.id.et_passwordSignup2);
        mBtnRegister = findViewById(R.id.button_signupSignup);
        mTextLogin = findViewById(R.id.text_login);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                finish();
            }
        });
    }

    private void registerUser() {
        mViewUser.setError(null);
        mViewPassword.setError(null);
        mViewPassword2.setError(null);
        View focus = null;
        boolean cancel = false;

        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();
        String confirmPassword = mViewPassword2.getText().toString();

        if (TextUtils.isEmpty(user)) {
            mViewUser.setError("Username harus diisi");
            focus = mViewUser;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            mViewPassword.setError("Password harus diisi");
            focus = mViewPassword;
            cancel = true;
        }

        if (!TextUtils.equals(password, confirmPassword)) {
            mViewPassword2.setError("Password tidak cocok");
            focus = mViewPassword2;
            cancel = true;
        }

        if (cancel) {
            focus.requestFocus();
        } else {
            // Simpan user baru dan password ke Preferences atau database
            Preferences.setRegisteredUser(getBaseContext(), user);
            Preferences.setRegisteredPass(getBaseContext(), password);

            // Set status login ke false setelah registrasi sukses
            Preferences.setLoggedInStatus(getBaseContext(), false);

            // Pindah ke LoginActivity setelah registrasi sukses
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finish(); // Mengarahkan ke LoginActivity dan menutup RegisterActivity
        }
    }
}
