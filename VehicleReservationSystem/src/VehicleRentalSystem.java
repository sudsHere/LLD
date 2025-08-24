import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<Store> stores;
    List<User> users;
    public VehicleRentalSystem() {
        // create vehicles
        List<Vehicle> vehicles = new ArrayList<>();
        VehicleFourWheeler v_1 = new VehicleFourWheeler(1,"Alto", "123",650, "Silver",LocalDate.now());
        VehicleFourWheeler v_2 = new VehicleFourWheeler(2, "Swift", "456", 850, "Red", LocalDate.of(2023, 5, 15));
        VehicleFourWheeler v_3 = new VehicleFourWheeler(3, "Creta", "789", 1200, "White", LocalDate.of(2022, 11, 5));
        VehicleFourWheeler v_4 = new VehicleFourWheeler(4, "Fortuner", "101", 2000, "Black", LocalDate.of(2024, 2, 20));
        vehicles.add(v_1);
        vehicles.add(v_2);
        vehicles.add(v_3);
        vehicles.add(v_4);
        // Create inventory_manager
        InventoryManager manager1 = new InventoryManager(vehicles);
        // create stores
        // Store 1;
        Location loc_1 = new Location("12312.123","12312.1231", "abc", "def");
        Store store1 = new Store(manager1,loc_1);

        // ===== Store 2 vehicles =====
        List<Vehicle> vehicles2 = new ArrayList<>();
        vehicles2.add(new VehicleFourWheeler(3, "Creta", "789", 1200, "White", LocalDate.of(2022, 11, 5)));
        vehicles2.add(new VehicleFourWheeler(4, "Fortuner", "101", 2000, "Black", LocalDate.of(2024, 2, 20)));
        InventoryManager manager2 = new InventoryManager(vehicles2);
        Location loc_2 = new Location("98765.432", "98765.4321", "ghi", "jkl");
        Store store2 = new Store(manager2, loc_2);

        // ===== Store 3 vehicles =====
        List<Vehicle> vehicles3 = new ArrayList<>();
        vehicles3.add(new VehicleFourWheeler(5, "Baleno", "202", 900, "Blue", LocalDate.of(2023, 8, 12)));
        vehicles3.add(new VehicleFourWheeler(6, "Innova", "303", 1800, "Grey", LocalDate.of(2021, 7, 3)));
        InventoryManager manager3 = new InventoryManager(vehicles3);
        Location loc_3 = new Location("56789.101", "56789.1011", "mno", "pqr");
        Store store3 = new Store(manager3, loc_3);

        this.stores = new ArrayList<>();
        this.stores.add(store1);
        this.stores.add(store2);
        this.stores.add(store3);
    }

    public Store GetStore(Location loc){
        for(Store s: stores){
            Location storeLoc = s.GetLocation();
            if (storeLoc.GetLatitude().equals(loc.GetLatitude()) &&
                    storeLoc.GetLongitude().equals(loc.GetLongitude())) {
                return s;
            }
        }
        return null;
    }
}
