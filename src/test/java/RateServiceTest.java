import model.Route;
import model.Trip;
import model.Vehicle;
import org.junit.Test;
import service.RateService;
import service.RateServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static model.Trip.TripType.SWIFT;
import static model.Vehicle.FuelType.PETROL;
import static model.Vehicle.VehicleType.CAR;
import static org.junit.Assert.assertEquals;

public class RateServiceTest {

    private final int CAR_CAPACITY = 4;
    private final int PASSENGER_COUNT = 4;

    @Test
    public void calculateRate_ValidTrip_Success(){
        Trip trip = new Trip(SWIFT, getVehicle(), getRoutes(), PASSENGER_COUNT);

        RateService rateService = new RateServiceImpl();
        double actual = rateService.calculateRate(trip);

        assertEquals(17.0,actual,0.0001);
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
