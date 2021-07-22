package service;

import model.Trip;

public interface ExpenseService {

    default double calculateExpense(Trip trip) {
        return 15.0 * trip.getTotalDistance();
    }

}
