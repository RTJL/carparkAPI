package app.carparksg.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.carparksg.api.model.Location;

public class LocationTest {

    private Location location;
    private String address;
    private Double lat;
    private Double lng;

    @Before
    public void setUp() {
        this.address = "313@Somerset";
        this.lat = 1.30084;
        this.lng = 103.83872;
        Location location = new Location(address, lat, lng);
        this.location = location;
    }

    @Test
    public void testGetAddress() {
        assertEquals(address, location.getAddress());
    }

    @Test
    public void testGetLat() {
        assertEquals(lat, location.getLat());
    }

    @Test
    public void testGetLng() {
        assertEquals(lng, location.getLng());
    }

    @Test
    public void testEquals() {
        assertEquals(location, location);
    }



}