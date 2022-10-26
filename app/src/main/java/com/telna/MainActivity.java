package com.telna;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.telna.models.User;
import com.telna.views.HomeActivity;
import com.telna.views.onboarding.LoginRegisterActivity;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private boolean isLoggedIn;
    private String userModel;

    Gson json = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("telna", Context.MODE_PRIVATE);
        isLoggedIn = prefs.getBoolean("isLogin", false);
        userModel = prefs.getString("user", "");

        if (isLoggedIn) {
            User user = json.fromJson(userModel, User.class);

            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            homeIntent.putExtra("user", userModel);
            startActivity(homeIntent);
            finish();
            return;
        }

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginRegisterIntent = new Intent(MainActivity.this, LoginRegisterActivity.class);
                loginRegisterIntent.putExtra("isLogin", true);
                startActivity(loginRegisterIntent);
            }
        }, 2000);

        setContentView(R.layout.activity_main);

        initActions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initActions() {
//
    }
}