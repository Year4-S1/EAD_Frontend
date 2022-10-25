package com.telna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.widget.ImageView;

import com.telna.views.SearchActivity;
import com.telna.views.SearchResultsActivity;
import com.telna.views.StationInfoActivity;
import com.telna.views.onboarding.LoginRegisterActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = this.getSharedPreferences("s", Context.MODE_PRIVATE);
//        boolean isLoggedIn = sharedPreferences.getBoolean(getString(R.string.logged_state), false);

//        if (isLoggedIn) {
//            Intent registerIntent = new Intent(MainActivity.this, DashboardActivity.class);
//            startActivity(registerIntent);
//            finish();
//            return;
//        }
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//            Intent loginRegisterIntent = new Intent(MainActivity.this, LoginRegisterActivity.class);
//            loginRegisterIntent.putExtra("isLogin",true);
//            startActivity(loginRegisterIntent);

                Intent searchIntent = new Intent(MainActivity.this, StationInfoActivity.class);
                startActivity(searchIntent);
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