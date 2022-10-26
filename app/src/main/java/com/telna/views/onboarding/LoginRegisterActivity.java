package com.telna.views.onboarding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.telna.R;
import com.telna.models.User;
import com.telna.util.Constants;
import com.telna.util.Utils;
import com.telna.views.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginRegisterActivity extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    private static LoginRegisterActivity context;

    private LinearLayout llUsername;
    private TextView tvSign, tvConfirm, tvTitle, tvBottomText;
    private EditText etUsername, etPhone, etPassword;

    private String username, phone, password;
    private boolean isLogin = true;

    private RequestQueue queue;
    private JsonObjectRequest request;

    Gson json = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        context = this;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        isLogin = getIntent().getBooleanExtra("isLogin", true);

        initView();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {

        llUsername = findViewById(R.id.ll_username);
        tvTitle = findViewById(R.id.tv_title);
        tvSign = findViewById(R.id.tv_sign);
        tvBottomText = findViewById(R.id.tv_bottomText);
        etUsername = findViewById(R.id.et_username);
        etPhone = findViewById(R.id.et_phone_num);
        etPassword = findViewById(R.id.et_password);
        tvConfirm = findViewById(R.id.tv_confirm);

        initComponents();

        //============ temp ================
        etPhone.setText("0711111111");
        etPassword.setText("cust1");
        //==================================

        tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLogin) {
                    isLogin = false;
                } else {
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
                try {
                    if (isLogin) {
                        login();
                    } else {
                        register();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void initComponents() {
        if (isLogin) {
            tvTitle.setText("WELCOME BACK!");
            tvBottomText.setText("Do not have a profile?");
            tvSign.setText("Sign Up");
            llUsername.setVisibility(View.GONE);
            tvConfirm.setText("Login");
        } else {
            tvTitle.setText("REGISTER!");
            tvBottomText.setText("Already have an Account? ");
            tvSign.setText("Sign In");
            llUsername.setVisibility(View.VISIBLE);
            tvConfirm.setText("Register");
        }
    }

    private void login() throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);
        if (!phone.isEmpty() && !password.isEmpty()) {
            JSONObject loginDetails = new JSONObject();
            loginDetails.put("Phone", phone);
            loginDetails.put("Password", password);

            request = new JsonObjectRequest(
                    Request.Method.POST,
                    Constants.BASEURL + "/api/user/login",
                    loginDetails,
                    response -> {
                        Toast.makeText(getApplicationContext(), "Login Successful ", Toast.LENGTH_LONG).show();

                        User user = json.fromJson(String.valueOf(response), User.class);
                        String userJson = json.toJson(user);

                        SharedPreferences prefs = getSharedPreferences("telna", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putBoolean("isLogin", true);
                        editor.putString("user", userJson);
                        editor.apply();

                        Intent homeIntent = new Intent(LoginRegisterActivity.this, HomeActivity.class);
                        homeIntent.putExtra("user", userJson);
                        startActivity(homeIntent);
                    },
                    error -> {
                        System.out.println(error.toString());
                        Toast.makeText(getApplicationContext(), "Login Failed ", Toast.LENGTH_LONG).show();
                    }
            );
            queue.add(request);
        } else {
            Utils.showToast("Please fill the fields", context);
        }
    }

    private void register() throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);
        if (!phone.isEmpty() && !password.isEmpty() && !username.isEmpty()) {
            JSONObject registerDetails = new JSONObject();
            registerDetails.put("Name", etUsername.getText());
            registerDetails.put("Phone", etPhone.getText());
            registerDetails.put("Password", etPassword.getText());
            registerDetails.put("UserType", "Customer");
            registerDetails.put("LoginStatus", false);

            request = new JsonObjectRequest(
                    Request.Method.POST,
                    Constants.BASEURL + "/api/user/create",
                    registerDetails,
                    response -> {
                        Toast.makeText(getApplicationContext(), "Login Successful ", Toast.LENGTH_LONG).show();

                        User user = json.fromJson(String.valueOf(response), User.class);
                        String userJson = json.toJson(user);

                        SharedPreferences prefs = getSharedPreferences("telna", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putBoolean("isLogin", true);
                        editor.putString("user", userJson);
                        editor.apply();

                        Intent homeIntent = new Intent(LoginRegisterActivity.this, HomeActivity.class);
                        homeIntent.putExtra("user", userJson);
                        startActivity(homeIntent);
                    },
                    error -> {
                        System.out.println(error.toString());
                        Toast.makeText(getApplicationContext(), "Register Failed ", Toast.LENGTH_LONG).show();
                    }
            );
            queue.add(request);
        } else {
            Utils.showToast("Please fill the fields", context);
        }
    }

}