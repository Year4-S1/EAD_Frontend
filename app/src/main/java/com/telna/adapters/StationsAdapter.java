package com.telna.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.telna.R;
import com.telna.models.FuelStation;
import com.telna.views.HomeActivity;
import com.telna.views.onboarding.LoginRegisterActivity;
import com.telna.views.user.SearchResultsActivity;

import java.util.ArrayList;

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder> {
    private ArrayList<FuelStation> fuelStations;

    public StationsAdapter(ArrayList<FuelStation> fuelStations) {
        this.fuelStations = fuelStations;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_filling_station_info_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FuelStation station = fuelStations.get(position);

        holder.getStationTitle().setText(station.getStationName());
        holder.getStationLocation().setText(station.getLocation());
        holder.getQuantity().setText(String.valueOf(station.getAmountOfFuel()));

        holder.getBody().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                               

                System.out.println("Clicked card");
            }
        });
    }

    @Override
    public int getItemCount() {
        return fuelStations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stationTitle;
        private TextView stationLocation;
        private TextView quantity;
        private ConstraintLayout body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stationTitle = (TextView) itemView.findViewById(R.id.tv_station_title);
            stationLocation = itemView.findViewById(R.id.tv_location);
            quantity = itemView.findViewById(R.id.tv_fuel);


            body = (ConstraintLayout) itemView.findViewById(R.id.bodyLayout);
        }

        public TextView getStationTitle() {
            return stationTitle;
        }

        public TextView getStationLocation() {
            return stationLocation;
        }

        public TextView getQuantity() {
            return quantity;
        }

        public ConstraintLayout getBody() {
            return body;
        }
    }
}
