package com.telna.views.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.telna.R;
import com.telna.adapters.StationsAdapter;
import com.telna.models.FuelStation;
import com.telna.util.enums.FuelTypes;
import com.telna.util.enums.VehicleTypes;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {
    private StationsAdapter stationsAdapter;
    private ArrayList<FuelStation> fuelStations = new ArrayList<FuelStation>();
    private RecyclerView stationsLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        initView();
    }

    private void initView() {
        stationsLoader = findViewById(R.id.rv_stations);
        stationsAdapter = new StationsAdapter(fuelStations);
        stationsLoader.setAdapter(stationsAdapter);
        stationsLoader.setLayoutManager(new LinearLayoutManager(this));

//        fuelStations.add(new FuelStation("name", "loca1", new FuelTypes[]{FuelTypes.PETROL92, FuelTypes.PETROL95, FuelTypes.DIESEL}, new VehicleTypes[]{VehicleTypes.BIKES, VehicleTypes.LIGHT}));
//        fuelStations.add(new FuelStation("name1", "loca2", new FuelTypes[]{FuelTypes.PETROL92, FuelTypes.PETROL95}, new VehicleTypes[]{VehicleTypes.BIKES, VehicleTypes.LIGHT}));
//        fuelStations.add(new FuelStation("name2", "loca3", new FuelTypes[]{FuelTypes.PETROL92, FuelTypes.PETROL95, FuelTypes.DIESEL, FuelTypes.SUPERDIESEL}, new VehicleTypes[]{VehicleTypes.BIKES, VehicleTypes.LIGHT}));

    }
}