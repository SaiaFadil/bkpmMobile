package com.example.usingpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mViewUser, mViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mViewUser = findViewById(R.id.et_emailSignin);
        mViewPassword = findViewById(R.id.et_passwordSignin);

        mViewPassword.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                razia();
                return true;
            }else {
                return false;
            }
        });

        Button signInButton = findViewById(R.id.button_siginSignin);
        signInButton.setOnClickListener((v) -> {
            razia();
        });

        Button signUpButton = findViewById(R.id.button_signupSignin);
        signUpButton.setOnClickListener((v) -> {
            startActivity(new Intent(getBaseContext(), RegisterActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())) {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
            finish();
        }
    }

    private void razia() {
        mViewUser.setError(null);
        mViewPassword.setError(null);
        View focus = null;
        boolean cancel = false;

        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();

        if (TextUtils.isEmpty(user)) {
            mViewUser.setError("Username harus diisi");
            focus = mViewUser;
            cancel = true;
        } else if (!cekUser(user)) {
            mViewUser.setError("Username tidak ada");
            focus = mViewUser;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            mViewPassword.setError("Password harus diisi");
            focus = mViewPassword;
            cancel = true;
        } else if (!cekPassword(password)) {
            mViewPassword.setError("Password salah");
            focus = mViewPassword;
            cancel = true;
        }

        if (cancel) {
            focus.requestFocus();
        } else {
            masuk();
        }
    }

    private void masuk() {
        Preferences.setLoggedInStatus(getBaseContext(), true);
        Preferences.setLoggedUser(getBaseContext(), mViewUser.getText().toString());

        Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getBaseContext(), MainActivity.class));
        finish();
    }

    private boolean cekPassword(String password) {
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }

    private boolean cekUser(String user) {
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}
