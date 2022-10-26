package com.telna.views;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.telna.R;
import com.telna.models.User;
import com.telna.views.user.SearchActivity;


public class HomeActivity extends AppCompatActivity {
    private TextView tvUserName;
    private LinearLayout search;
    private ImageView logo;
    private User user;

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
    }
}