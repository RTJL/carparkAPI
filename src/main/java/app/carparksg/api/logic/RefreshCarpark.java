package app.carparksg.api.logic;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.carparksg.api.model.Carpark;
import app.carparksg.api.model.CarparkDAO;
import app.carparksg.api.model.Location;
import app.carparksg.api.model.LtaCarpark;

@Component
public class RefreshCarpark {

    private GetLtaCarpark getLtaCarpark;
    private HashMap<String, Carpark> carparks;
    private CarparkDAO carparkDAO;

    public RefreshCarpark() {
        getLtaCarpark = new GetLtaCarpark();
        carparks = new HashMap<>();
        carparkDAO = CarparkDAO.getInstance();
    }

    @Scheduled(cron = "0 * * * * *", zone = "Asia/Singapore")
    // @Scheduled(fixedRate = 3000)
    public void updateData() {
        System.out.println("Starting update");
        ArrayList<LtaCarpark> ltaCarparks = getLtaCarpark.getAllLtaCarpark();
        for (LtaCarpark ltaCarpark : ltaCarparks) {
            if (!carparks.containsKey(ltaCarpark.getCarParkID()) ) {
                Location newLocation = new Location(ltaCarpark.getDevelopment(), ltaCarpark.getLat(), ltaCarpark.getLng());
                Carpark newCarpark = new Carpark(ltaCarpark.getCarParkID(), newLocation, ltaCarpark.getAvailableLots());
                carparks.put(newCarpark.getId(), newCarpark);
            } else {
                Carpark carpark = carparks.get(ltaCarpark.getCarParkID());
                carpark.setFreeLots(ltaCarpark.getAvailableLots());
            }
        }
        carparkDAO.setCarparks(carparks);
        System.out.println("data updated.");
    }
}