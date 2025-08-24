import java.time.LocalDate;

public class User {
    String first_name;
    String last_name;
    String license_number;
    LocalDate dob;

    public User(String f_name, String l_name, String license_number, LocalDate dob) {
        this.dob = dob;
        this.license_number = license_number;
        this.first_name = f_name;
        this.last_name = l_name;
    }

    public String GetFirstName() {
        return first_name;
    }

    public String GetLastName() {
        return last_name;
    }

    public String GetLicenseNumber() {
        return license_number;
    }
}