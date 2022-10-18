package com.telna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = this.getSharedPreferences("s",Context.MODE_PRIVATE);
//        boolean isLoggedIn = sharedPreferences.getBoolean(getString(R.string.logged_state), false);

//        if (isLoggedIn) {
//            Intent registerIntent = new Intent(MainActivity.this, DashboardActivity.class);
//            startActivity(registerIntent);
//            finish();
//            return;
//        }

        setContentView(R.layout.activity_main);
//        mLogin = findViewById(R.id.btnLogin);
//        mRegister = findViewById(R.id.btnRegister);

        initActions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initActions() {
//        mLogin.setOnClickListener(view -> {
//            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(loginIntent);
//        });
//        mRegister.setOnClickListener(view -> {
//            Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
//            startActivity(registerIntent);
//        });
    }
}