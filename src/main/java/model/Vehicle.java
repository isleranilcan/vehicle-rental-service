package model;

public class Vehicle {

    private VehicleType vehicleType;
    private FuelType fuelType;
    private boolean isAC;
    private int passengerCapacity;

    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType, FuelType fuelType, boolean isAC, int passengerCapacity) {
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.isAC = isAC;
        this.passengerCapacity = passengerCapacity;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isAC() {
        return isAC;
    }

    public void setAC(boolean AC) {
        isAC = AC;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public enum VehicleType {
        SUV,
        CAR,
        VAN,
        BUS;
    }

    public enum FuelType {
        PETROL,
        DIESEL;
    }
}
