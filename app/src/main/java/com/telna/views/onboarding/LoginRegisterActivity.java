package com.telna.views.onboarding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.telna.R;
import com.telna.util.Utils;

public class LoginRegisterActivity extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    private static LoginRegisterActivity context;

    private LinearLayout llUsername;
    private TextView tvSign, tvConfirm, tvTitle, tvBottomText, tvForgotPassword;
    private EditText etUsername, etPhone, etPassword;

    private String username, phone, password;
    private boolean isLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        context = this;

        isLogin = getIntent().getBooleanExtra("isLogin", true);

        initView();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        llUsername = findViewById(R.id.ll_username);
        tvTitle = findViewById(R.id.tv_title);
        tvSign = findViewById(R.id.tv_sign);
        tvBottomText = findViewById(R.id.tv_bottomText);
        tvForgotPassword = findViewById(R.id.tv_forgotPassword);
        etUsername = findViewById(R.id.et_username);
        etPhone = findViewById(R.id.et_phone_num);
        etPassword = findViewById(R.id.et_password);
        tvConfirm = findViewById(R.id.tv_confirm);

        initComponents();

        tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLogin){
                    isLogin = false;
                }else{
                    isLogin = true;
                }
                initComponents();
            }
        });

        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = etPhone.getText().toString();
                password = etPassword.getText().toString();
                username = etUsername.getText().toString();
                login();
            }
        });
    }

    private void initComponents() {
        if (isLogin) {
            tvTitle.setText("WELCOME BACK!");
            tvBottomText.setText("Do not have a profile?");
            tvSign.setText("Sign Up");
            llUsername.setVisibility(View.GONE);
            tvForgotPassword.setVisibility(View.VISIBLE);
        } else {
            tvTitle.setText("REGISTER!");
            tvBottomText.setText("Already have an Account? ");
            tvSign.setText("Sign In");
            llUsername.setVisibility(View.VISIBLE);
            tvForgotPassword.setVisibility(View.GONE);
        }
    }

    private void login() {
        if (!phone.isEmpty() && !password.isEmpty()) {
            //
        } else {
            Utils.showToast("Please fill the fields", context);
        }
    }

    private void register() {
        if (!phone.isEmpty() && !password.isEmpty() && !username.isEmpty()) {
            //
        } else {
            Utils.showToast("Please fill the fields", context);
        }
    }

}