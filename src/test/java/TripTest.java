import model.Route;
import model.Trip;
import model.Vehicle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Trip.TripType.COMFORT;
import static model.Vehicle.FuelType.PETROL;
import static model.Vehicle.VehicleType.CAR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TripTest {

    private final int CAR_CAPACITY = 4;

    @Test
    public void trip_Given_PassengerZero_ExceptionThrown() {
        String expectedExceptionMessage = "passenger count must be bigger than zero";
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> new Trip(COMFORT, getVehicle(), getRoutes(), 0));
        assertEquals(expectedExceptionMessage, runtimeException.getMessage());
    }

    private Vehicle getVehicle() {
        return new Vehicle(CAR, PETROL, true, CAR_CAPACITY);
    }

    private List<Route> getRoutes() {
        List<Route> list = new ArrayList<>();
        list.add(Route.puneToBangalore);
        list.add(Route.mumbaiToChennai);
        list.add(Route.mumbaiToDelhi);

        return list;
    }
}
