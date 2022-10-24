package com.telna.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.telna.R;
import com.telna.adapters.StationsAdapter;
import com.telna.models.FuelStation;
import com.telna.util.Constants;
import com.telna.util.enums.FuelTypes;
import com.telna.util.enums.VehicleTypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SearchActivity extends AppCompatActivity {
    private Spinner ddFuel;
    private FuelTypes[] fuelTypes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();

    }

    private void initView() {
        ddFuel = findViewById(R.id.dd_fuel);
        setupFuelTypes();
        fuelTypes = new FuelTypes[]{FuelTypes.PETROL92, FuelTypes.PETROL95, FuelTypes.DIESEL, FuelTypes.SUPERDIESEL};

    }

    private void setupFuelTypes() {
//        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fuelTypes);
//        ddFuel.setAdapter(adapter);
    }
}