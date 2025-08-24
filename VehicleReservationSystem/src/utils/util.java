package utils;

import enums.BookingStatus;

public class util {
    public static String GetBookingStatusString (BookingStatus status) {
        switch (status) {
            case Booked -> {
                return "Booked";
            }
            case Processing -> {
                return "Processing";
            }
            case Released -> {
                return "Released";
            }
            case Available -> {
                return "Available";
            }
            case Maintenance -> {
                return "Under maintenance";
            }
        }
        return "No status avaialable";
    }
}
