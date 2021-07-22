package model;

import java.util.List;

public class Trip {

    private TripType tripType;
    private Vehicle vehicle;
    private List<Route> routes;
    private int passengerCount;

    public Trip() {
    }

    public Trip(TripType tripType, Vehicle vehicle, List<Route> routes, int passengerCount) {
        this.tripType = tripType;
        this.vehicle = vehicle;
        this.routes = routes;
        this.passengerCount = passengerCount;
        validate();
    }

    public TripType getTripType() {
        return tripType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public double getTotalDistance(){
        return getRoutes().stream().mapToDouble(Route::getDistance).sum();
    }

    private void validate() {
        if (passengerCount<=0) {
            throw new RuntimeException("passenger count must be bigger than zero");
        }
        if (routes == null || routes.isEmpty()) {
            throw new RuntimeException("routes cannot be null or empty");
        }
    }

    public enum TripType {
        ECONOMY,
        SWIFT,
        COMFORT;
    }
}
