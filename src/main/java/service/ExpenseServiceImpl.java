package service;

import model.Trip;

public class ExpenseServiceImpl implements ExpenseService {

    RateService rateService = new RateServiceImpl();

    @Override
    public double calculateExpense(Trip trip) {
        double totalDistance = trip.getTotalDistance();
        double rate = rateService.calculateRate(trip);
        return totalDistance * rate;
    }

}
