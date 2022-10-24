package com.telna.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telna.R;
import com.telna.models.FuelStation;

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
        String temp;

        System.out.println(station.getStationName());

        holder.getStationTitle().setText(station.getStationName());
        for (int i = 0; i < station.getFuelTypes().length; i++) {
            if (i == 0) {
                temp = station.getFuelTypes()[i].toString();
                holder.getFuelType1().setText(temp);
                holder.getFuelType1().setVisibility(View.VISIBLE);
            } else if (i == 1) {
                temp = station.getFuelTypes()[i].toString();
                holder.getFuelType2().setText(temp);
                holder.getFuelType2().setVisibility(View.VISIBLE);
            } else if (i == 3) {
                temp = station.getFuelTypes()[i].toString();
                holder.getFuelType3().setText(temp);
                holder.getFuelType3().setVisibility(View.VISIBLE);
            } else if (i == 4) {
                temp = station.getFuelTypes()[i].toString();
                holder.getFuelType4().setText(temp);
                holder.getFuelType4().setVisibility(View.VISIBLE);
            }
        }
        for (int i = 0; i < station.getVehicleTypes().length; i++) {
            if (i == 0) {
                temp = station.getVehicleTypes()[i].toString();
                holder.getVehicle1().setText(temp);
                holder.getVehicle1().setVisibility(View.VISIBLE);
            } else if (i == 1) {
                temp = station.getVehicleTypes()[i].toString();
                holder.getVehicle2().setText(temp);
                holder.getVehicle2().setVisibility(View.VISIBLE);
            } else if (i == 3) {
                temp = station.getVehicleTypes()[i].toString();
                holder.getVehicle3().setText(temp);
                holder.getVehicle3().setVisibility(View.VISIBLE);
            } else if (i == 4) {
                temp = station.getVehicleTypes()[i].toString();
                holder.getVehicle4().setText(temp);
                holder.getVehicle4().setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return fuelStations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stationTitle;
        private TextView stationLocation;
        private TextView fuelType1, fuelType2, fuelType3, fuelType4;
        private TextView vehicle1, vehicle2, vehicle3, vehicle4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stationTitle = (TextView) itemView.findViewById(R.id.tv_station_title);
//            stationLocation = = itemView.findViewById(R.id.tv_s
            fuelType1 = (TextView) itemView.findViewById(R.id.tv_fuel1);
            fuelType2 = (TextView) itemView.findViewById(R.id.tv_fuel2);
            fuelType3 = (TextView) itemView.findViewById(R.id.tv_fuel3);
            fuelType4 = (TextView) itemView.findViewById(R.id.tv_fuel4);

            vehicle1 = (TextView) itemView.findViewById(R.id.tv_bikes);
            vehicle2 = (TextView) itemView.findViewById(R.id.tv_tuks);
            vehicle3 = (TextView) itemView.findViewById(R.id.tv_light);
            vehicle4 = (TextView) itemView.findViewById(R.id.tv_heavy);
        }

        public TextView getStationTitle() {
            return stationTitle;
        }

        public TextView getStationLocation() {
            return stationLocation;
        }

        public TextView getFuelType1() {
            return fuelType1;
        }

        public TextView getFuelType2() {
            return fuelType2;
        }

        public TextView getFuelType3() {
            return fuelType3;
        }

        public TextView getFuelType4() {
            return fuelType4;
        }

        public TextView getVehicle1() {
            return vehicle1;
        }

        public TextView getVehicle2() {
            return vehicle2;
        }

        public TextView getVehicle3() {
            return vehicle3;
        }

        public TextView getVehicle4() {
            return vehicle4;
        }
    }
}
