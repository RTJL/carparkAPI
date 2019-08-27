package app.carparksg.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CarparkDAO {
    
    private static CarparkDAO carparkDAO;
    private HashMap<String, Carpark> carparks;

    private CarparkDAO() {
        carparks = new HashMap<>();
    }

    public static CarparkDAO getInstance() {
        if (carparkDAO == null) {
            carparkDAO = new CarparkDAO();
        }
        return carparkDAO;
    }

    public synchronized void setCarparks(HashMap<String, Carpark> carparks) {
        this.carparks = carparks;
    }
    
    public synchronized Optional<Carpark> getCarpark(String carparkId) {
        if (carparks.containsKey(carparkId)) {
            Carpark carpark = carparks.get(carparkId);
            return Optional.of(carpark);
        }
        return Optional.empty();
    }

    public synchronized List<Carpark> getAllCarpark() {
        List<Carpark> allCarpark = new ArrayList<Carpark>(carparks.values());
        return allCarpark;
    }

}