package app.carparksg.api.model;

public class Carpark {
    private String id;
    private Location location;
    private int freeLots;

    public Carpark(String id, Location location, int freeLots) {
        this.id = id;
        this.location = location;
        this.freeLots = freeLots;
    }

    public String getId() {
        return this.id;
    }

    public Location getLocation() {
        return this.location;
    }

    public int getFreeLots() {
        return this.freeLots;
    }

    public void setFreeLots(int freeLots) {
        this.freeLots = freeLots;
    }

}