package com.telna.models;

import com.telna.util.enums.FuelTypes;
import com.telna.util.enums.VehicleTypes;

public class FuelStation {
    private String Id;
    private String StationID;
    private String StationName;
    private String StationOwnerID;
    private String Location;
    private String District;
    private FuelTypes[] FuelTypes;
    private VehicleTypes[] VehicleTypes;
    private boolean Availability;
    private int AmountOfFuel;

    public FuelStation(String id, String stationID, String stationName, String stationOwnerID, String location, String district, com.telna.util.enums.FuelTypes[] fuelTypes, com.telna.util.enums.VehicleTypes[] vehicleTypes, boolean availability, int amountOfFuel) {
        Id = id;
        StationID = stationID;
        StationName = stationName;
        StationOwnerID = stationOwnerID;
        Location = location;
        District = district;
        FuelTypes = fuelTypes;
        VehicleTypes = vehicleTypes;
        Availability = availability;
        AmountOfFuel = amountOfFuel;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStationID() {
        return StationID;
    }

    public void setStationID(String stationID) {
        StationID = stationID;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public String getStationOwnerID() {
        return StationOwnerID;
    }

    public void setStationOwnerID(String stationOwnerID) {
        StationOwnerID = stationOwnerID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public com.telna.util.enums.FuelTypes[] getFuelTypes() {
        return FuelTypes;
    }

    public void setFuelTypes(com.telna.util.enums.FuelTypes[] fuelTypes) {
        FuelTypes = fuelTypes;
    }

    public com.telna.util.enums.VehicleTypes[] getVehicleTypes() {
        return VehicleTypes;
    }

    public void setVehicleTypes(com.telna.util.enums.VehicleTypes[] vehicleTypes) {
        VehicleTypes = vehicleTypes;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    public int getAmountOfFuel() {
        return AmountOfFuel;
    }

    public void setAmountOfFuel(int amountOfFuel) {
        AmountOfFuel = amountOfFuel;
    }
}
