package com.telna.models;

import com.telna.util.enums.FuelTypes;
import com.telna.util.enums.VehicleTypes;

public class FuelStation {
    private IdDetails id;
    private String stationID;
    private String stationName;
    private String location;
    private String district;
    private FuelTypes[] fuelTypes;
    private VehicleTypes[] vehicleTypes;
    private boolean availability;
    private int amountOfFuel;

    public FuelStation(IdDetails id, String stationID, String stationName, String location, String district, FuelTypes[] fuelTypes, VehicleTypes[] vehicleTypes, boolean availability, int amountOfFuel) {
        this.id = id;
        this.stationID = stationID;
        this.stationName = stationName;
        this.location = location;
        this.district = district;
        this.fuelTypes = fuelTypes;
        this.vehicleTypes = vehicleTypes;
        this.availability = availability;
        this.amountOfFuel = amountOfFuel;
    }

    public IdDetails getId() {
        return id;
    }

    public void setId(IdDetails id) {
        this.id = id;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getAmountOfFuel() {
        return amountOfFuel;
    }

    public void setAmountOfFuel(int amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }
}
