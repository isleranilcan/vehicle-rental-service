package service;

import model.Trip;
import model.Vehicle;

public interface RateService {

    default double calculateRate(Trip trip) {

        double rate = 0.0;

        Vehicle vehicle = trip.getVehicle();
        if (vehicle.getFuelType() == Vehicle.FuelType.DIESEL) {
            rate += 14.0;
        } else { //petrol and others if added
            rate += 15.0;
        }

        if (vehicle.isAC()) {
            rate += 2.0;
        }

        //can be placed lower or upper, apply discount before AC and ExtraPassengers or later?
        if (vehicle.getVehicleType() == Vehicle.VehicleType.BUS) {
            rate = rate * 0.98;
        }

        int extraPassengers = trip.getPassengerCount() - trip.getVehicle().getPassengerCapacity();
        if (extraPassengers > 0) {
            rate += extraPassengers;
        }

        return rate;
    }

}
