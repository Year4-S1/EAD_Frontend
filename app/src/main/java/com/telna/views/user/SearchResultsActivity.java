package com.telna.views.user;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.telna.R;
import com.telna.adapters.StationsAdapter;
import com.telna.models.FuelStation;
import com.telna.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchResultsActivity extends AppCompatActivity {
    private ImageView ivBack;

    private StationsAdapter stationsAdapter;
    private ArrayList<FuelStation> fuelStations = new ArrayList<>();
    private RecyclerView stationsLoader;
    private RequestQueue queue;
    private String searchParam;
    private JsonArrayRequest request;
    Gson json = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        fuelStations.clear();

        initView();
    }

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        try {
            getData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getData() throws JSONException {
        String type = getIntent().getStringExtra("type");
        if (type == "search") {
            searchParam = getIntent().getStringExtra("searchParam");
            search(searchParam);
        } else {
            findAll();
        }
    }

    private void findAll() throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);
        request = new JsonArrayRequest(
                Request.Method.GET,
                Constants.BASEURL + "/api/station/get/all",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        FuelStation[] dataModels = json.fromJson(response.toString(), FuelStation[].class);
                        fuelStations.addAll(Arrays.asList(dataModels));

                        stationsLoader = findViewById(R.id.rv_stations);
                        stationsAdapter = new StationsAdapter(fuelStations);
                        stationsLoader.setAdapter(stationsAdapter);
                        stationsLoader.setLayoutManager(new LinearLayoutManager(SearchResultsActivity.this));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        queue.add(request);
    }

    private void search(String param) throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);

        request = new JsonArrayRequest(
                Request.Method.GET,
                Constants.BASEURL + "/api/station/search/" + param,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        FuelStation[] dataModels = json.fromJson(response.toString(), FuelStation[].class);
                        fuelStations.addAll(Arrays.asList(dataModels));

                        stationsLoader = findViewById(R.id.rv_stations);
                        stationsAdapter = new StationsAdapter(fuelStations);
                        stationsLoader.setAdapter(stationsAdapter);
                        stationsLoader.setLayoutManager(new LinearLayoutManager(SearchResultsActivity.this));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        queue.add(request);
    }
}