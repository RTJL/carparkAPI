package app.carparksg.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.carparksg.api.model.Carpark;
import app.carparksg.api.model.Location;

public class CarparkTest {
    private String id;
    private Location location;
    private int freeLots;
    private Carpark carpark;

    @Before
    public void setUp() {
        this.id = "313@Somerset";
        this.freeLots = 113;

        Double lat = 1.30084;
        Double lng = 103.83872;
        Location location = new Location(id, lat, lng);
        this.location = location;
        
        Carpark carpark = new Carpark(this.id, this.location, this.freeLots);
        this.carpark = carpark;
    }

    @Test
    public void testGetId() {
        assertEquals(id, carpark.getId());
    }

    @Test
    public void testGetLocation() {
        assertEquals(location, carpark.getLocation());
    }

    @Test
    public void testGetFreeLots() {
        assertEquals(freeLots, carpark.getFreeLots());
    }

    @Test
    public void testSetFreeLots() {
        freeLots = 10;
        carpark.setFreeLots(freeLots);
        assertEquals(freeLots, carpark.getFreeLots());
    }

    @Test
    public void testEquals() {
        assertEquals(carpark, carpark);
    }
}