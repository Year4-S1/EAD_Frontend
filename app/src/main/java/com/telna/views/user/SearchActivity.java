package com.telna.views.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.telna.R;
import com.telna.util.enums.FuelTypes;

import org.json.JSONException;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private Spinner ddDistrict;
    private TextView tvConfirm, tvByDistrict, tvByName;
    private LinearLayout lvDistrict, lvName, lvFindAll;
    private EditText etStation;
    private FuelTypes[] fuelTypes;
    private ArrayList<String> districts = new ArrayList<String>();
    private boolean isSearchByDistrict = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        ddDistrict = findViewById(R.id.dd_district);
        etStation = findViewById(R.id.et_station);
        tvConfirm = findViewById(R.id.tv_confirm);
        tvByDistrict = findViewById(R.id.tv_search_district);
        tvByName = findViewById(R.id.tv_search_name);
        lvDistrict = findViewById(R.id.lv_district);
        lvName = findViewById(R.id.lv_name);
        lvFindAll = findViewById(R.id.ll_findAll);

        setupDropdowns();
        searchBy();

        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String param;

                if (isSearchByDistrict) {
                    param = ddDistrict.getSelectedItem().toString();
                } else {
                    param = etStation.getText().toString();
                }

                Intent searchResult = new Intent(SearchActivity.this, SearchResultsActivity.class);
                searchResult.putExtra("searchParam", param);
                searchResult.putExtra("type", "search");
                startActivity(searchResult);
                finish();
            }
        });

        tvByDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSearchByDistrict = true;
                searchBy();
            }
        });

        tvByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSearchByDistrict = false;
                searchBy();
            }
        });

        lvFindAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchResult = new Intent(SearchActivity.this, SearchResultsActivity.class);
                searchResult.putExtra("type", "all");
                startActivity(searchResult);
                finish();
            }
        });
    }

    private void searchBy() {
        if (isSearchByDistrict) {
            etStation.setText("");
            tvByDistrict.setBackground(ContextCompat.getDrawable(this, R.drawable.switch_active));
            tvByName.setBackground(ContextCompat.getDrawable(this, R.drawable.switch_inactive));
            lvDistrict.setVisibility(View.VISIBLE);
            lvName.setVisibility(View.GONE);
        } else {
            etStation.setText("");
            tvByName.setBackground(ContextCompat.getDrawable(this, R.drawable.switch_active));
            tvByDistrict.setBackground(ContextCompat.getDrawable(this, R.drawable.switch_inactive));
            lvName.setVisibility(View.VISIBLE);
            lvDistrict.setVisibility(View.GONE);
        }
    }

    private void setupDropdowns() {
        makeDistricts();
        ArrayAdapter districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, districts);
        ddDistrict.setAdapter(districtAdapter);
    }

    public void makeDistricts() {
        districts.add("Colombo");
        districts.add("Gampaha");
        districts.add("Kalutara");
        districts.add("Kandy");
        districts.add("Matale");
        districts.add("Nuwaraeliya");
        districts.add("Galle");
        districts.add("Matara");
        districts.add("Hambantota");
        districts.add("Jaffna");
        districts.add("Kilinochchi");
        districts.add("Mannar");
        districts.add("Vavuniya");
        districts.add("Mullaitivu");
        districts.add("Batticaloa");
        districts.add("Ampara");
        districts.add("Trincomalee");
        districts.add("Kurunegala");
        districts.add("Puttalam");
        districts.add("Anuradhapura");
        districts.add("Polonnaruwa");
        districts.add("Badulla");
        districts.add("Moneragala");
        districts.add("Ratnapura");
        districts.add("Kegalle");
    }
}