public class Location {
    String latitude;
    String longitude;
    String building_name;
    String street_name;

    public Location(String lat, String lon, String b_name, String s_name){
        this.longitude = lon;
        this.latitude = lat;
        this.building_name = b_name;
        this.street_name = s_name;
    }

    public String GetLongitude() {
        return this.longitude;
    }

    public String GetLatitude() {
        return this.latitude;
    }
}
