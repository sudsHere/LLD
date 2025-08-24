import enums.PaymentMode;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VehicleRentalSystem vrs = new VehicleRentalSystem();
        // Get the store at location
        Location loc = new Location("12312.123","12312.1231", "abc", "def");
        Store store = vrs.GetStore(loc);
        store.ListAllVehicles();

        // add filters
        Filters filters = new Filters("Red", 850);
        List<Vehicle> filtered_vehicles = store.ListAndGetFilteredVehicles(filters);

        if (!filtered_vehicles.isEmpty()) {
            // Book car with the filter
            // Today
            Date today = new Date();

            // Tomorrow
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_YEAR, 1);
            Date tomorrow = cal.getTime();
            store.BookVehicle(PaymentMode.UPI, filtered_vehicles.getFirst(), today, tomorrow);
        }

    }
}