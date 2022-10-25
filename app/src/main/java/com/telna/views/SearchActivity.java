package com.telna.views;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.telna.R;
import com.telna.util.enums.FuelTypes;

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
        setupDropdowns();
    }

    private void setupDropdowns() {
        fuelTypes = new FuelTypes[]{FuelTypes.PETROL92, FuelTypes.PETROL95, FuelTypes.DIESEL, FuelTypes.SUPERDIESEL};
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fuelTypes);
        ddFuel.setAdapter(adapter);
    }
}