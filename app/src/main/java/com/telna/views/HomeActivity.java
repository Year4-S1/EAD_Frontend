package com.telna.views;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.telna.R;
import com.telna.models.User;
import com.telna.util.Constants;
import com.telna.views.onboarding.LoginRegisterActivity;
import com.telna.views.user.SearchActivity;

import org.json.JSONException;


public class HomeActivity extends AppCompatActivity {
    private TextView tvUserName, tvLogout;
    private LinearLayout search;
    private ImageView logo;
    private User user;

    private RequestQueue queue;
    private JsonObjectRequest request;

    Gson json = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Gson gson = new Gson();
        user = gson.fromJson(getIntent().getStringExtra("user"), User.class);
        initView();
    }

    private void initView() {
        tvUserName = findViewById(R.id.tv_user_name);
        logo = findViewById(R.id.logo);
        search = findViewById(R.id.lv_search);
        tvLogout = findViewById(R.id.tv_logout);

        tvUserName.setText(user.getName());

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(logo, PropertyValuesHolder.ofFloat("scaleX", 1.1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.1f));
        scaleDown.setDuration(4000);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    logout();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void logout() throws JSONException {
        request = new JsonObjectRequest(
                Request.Method.PUT,
                Constants.BASEURL + "/api/user/logout/" + user.getId(),
                null,
                response -> {
                    Toast.makeText(getApplicationContext(), "Logout Successful ", Toast.LENGTH_LONG).show();

                    SharedPreferences prefs = getSharedPreferences("telna", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("isLogin", false);
                    editor.putString("user", null);
                    editor.apply();

                    Intent homeIntent = new Intent(HomeActivity.this, LoginRegisterActivity.class);
                    startActivity(homeIntent);
                    finish();
                },
                error -> {
                    System.out.println(error.toString());
                    Toast.makeText(getApplicationContext(), "Logout Failed ", Toast.LENGTH_LONG).show();
                }
        );
        queue.add(request);
    }
}