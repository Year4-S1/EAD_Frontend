package com.telna.models;
import com.telna.util.enums.FuelTypes;
import com.telna.util.enums.VehicleTypes;

public class FuelStation {
    private String stationName;
    private String location;
    private FuelTypes[] fuelTypes;
    private VehicleTypes[] vehicleTypes;

    public FuelStation(String stationName, String location, FuelTypes[] fuelTypes, VehicleTypes[] vehicleTypes) {
        this.stationName = stationName;
        this.location = location;
        this.fuelTypes = fuelTypes;
        this.vehicleTypes = vehicleTypes;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public FuelTypes[] getFuelTypes() {
        return fuelTypes;
    }

    public void setFuelTypes(FuelTypes[] fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public VehicleTypes[] getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(VehicleTypes[] vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
