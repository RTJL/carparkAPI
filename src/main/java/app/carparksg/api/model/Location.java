package app.carparksg.api.model;

public class Location {
    private String address;
    private Double lat, lng; 

    public Location(String address, Double lat, Double lng) {
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public String getAddress() {
        return this.address;
    }

    public Double getLat() {
        return this.lat;
    }

    public Double getLng() {
        return this.lng;
    }
}