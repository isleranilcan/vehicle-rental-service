import model.Route;
import model.Trip;
import model.Vehicle;
import org.junit.Test;
import service.ExpenseService;
import service.ExpenseServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static model.Trip.TripType.ECONOMY;
import static model.Trip.TripType.SWIFT;
import static model.Vehicle.FuelType.PETROL;
import static model.Vehicle.VehicleType.BUS;
import static model.Vehicle.VehicleType.CAR;
import static org.junit.Assert.assertEquals;

public class ExpenseServiceTest {

    private final int CAR_CAPACITY = 4;
    private final int BUS_CAPACITY = 40;
    private final int PASSENGER_COUNT = 4;
    private final int BUS_PASSENGER_COUNT = 60;

    @Test
    public void calculateExpense_ValidVehicle_Success() {
        Trip trip = new Trip(SWIFT, getVehicle(), getRoutes(), PASSENGER_COUNT);

        ExpenseService expenseService = new ExpenseServiceImpl();
        double expected = 72836.5;
        double actual = expenseService.calculateExpense(trip);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateExpense_ValidBus_Success() {
        Trip trip = new Trip(ECONOMY, getBus(), getRoutes(), BUS_PASSENGER_COUNT);

        ExpenseService expenseService = new ExpenseServiceImpl();
        double expected = 157069.77;
        double actual = expenseService.calculateExpense(trip);

        assertEquals(expected, actual, 0.0001);
    }

    private Vehicle getVehicle() {
        return new Vehicle(CAR, PETROL, true, CAR_CAPACITY);
    }

    private Vehicle getBus() {
        return new Vehicle(BUS, PETROL, true, BUS_CAPACITY);
    }

    private List<Route> getRoutes() {
        List<Route> list = new ArrayList<>();
        list.add(Route.puneToBangalore);
        list.add(Route.mumbaiToChennai);
        list.add(Route.mumbaiToDelhi);

        return list;
    }
}
