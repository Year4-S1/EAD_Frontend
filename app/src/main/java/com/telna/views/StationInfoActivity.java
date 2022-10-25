package com.telna.views;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.telna.R;
import com.telna.util.enums.FuelTypes;
import com.telna.util.enums.VehicleTypes;

public class StationInfoActivity extends AppCompatActivity {
    private TextView tvFuel1, tvFuel2, tvFuel3, tvFuel4;
    private TextView tvVehicle1, tvVehicle2, tvVehicle3, tvVehicle4;
    private TextView tvTitle, tvLocation, tvConfirm;
    private Spinner ddFuel, ddVehicle;

    private FuelTypes[] fuelTypes;
    private VehicleTypes[] vahicleTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_info);
        initView();
    }

    private void initView() {
        tvFuel1 = findViewById(R.id.tv_fuel1);
        tvFuel2 = findViewById(R.id.tv_fuel2);
        tvFuel3 = findViewById(R.id.tv_fuel3);
        tvFuel4 = findViewById(R.id.tv_fuel4);
        tvVehicle1 = findViewById(R.id.tv_bikes);
        tvVehicle2 = findViewById(R.id.tv_tuks);
        tvVehicle3 = findViewById(R.id.tv_light);
        tvVehicle4 = findViewById(R.id.tv_heavy);
        tvTitle = findViewById(R.id.tv_title);
        tvLocation = findViewById(R.id.tv_location);
        tvConfirm = findViewById(R.id.tv_confirm);
        ddFuel = findViewById(R.id.dd_fuel);
        ddVehicle = findViewById(R.id.dd_vehicle);

        setupDropdowns();
    }

    private void setupDropdowns() {
        fuelTypes = new FuelTypes[]{FuelTypes.PETROL92, FuelTypes.PETROL95, FuelTypes.DIESEL, FuelTypes.SUPERDIESEL};
        ArrayAdapter fuelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fuelTypes);
        ddFuel.setAdapter(fuelAdapter);

        vahicleTypes = new VehicleTypes[]{VehicleTypes.BIKES, VehicleTypes.TUKS, VehicleTypes.LIGHT, VehicleTypes.HEAVY};
        ArrayAdapter vehicleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, vahicleTypes);
        ddVehicle.setAdapter(vehicleAdapter);
    }
}