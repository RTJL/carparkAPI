package app.carparksg.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LtaCarpark {

    @JsonProperty("CarParkID")
    private String CarParkID;

    @JsonProperty("Area")
    private String Area;

    @JsonProperty("Development")
    private String Development;

    @JsonProperty("Location")
    private String Location;
    
    @JsonProperty("AvailableLots")
    private int AvailableLots;
    
    @JsonProperty("LotTypes")
    private String LotType;
    
    @JsonProperty("Agency")
    private String Agency;  

    public LtaCarpark() {
    }
    
    @Override
    public String toString() {
        return "LtaCarpark{" +
            "CarparkID='" + CarParkID + '\'' +
            ", Area='" + Area + '\'' +
            ", Development='" + Development + '\'' +
            ", Location='" + Location + '\'' +
            ", AvailableLots='" + AvailableLots + '\'' +
            ", LotType='" + LotType + '\'' +
            ", Agency='" + Agency +
            "}";
    }

    /**
     * @return String return the CarParkID
     */
    public String getCarParkID() {
        return CarParkID;
    }

    /**
     * @param CarParkID the CarParkID to set
     */
    public void setCarParkID(String CarParkID) {
        this.CarParkID = CarParkID;
    }

    /**
     * @return String return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     * @return String return the Development
     */
    public String getDevelopment() {
        return Development;
    }

    /**
     * @param Development the Development to set
     */
    public void setDevelopment(String Development) {
        this.Development = Development;
    }

    /**
     * @return String return the Location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * @param Location the Location to set
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     * @return int return the AvailableLots
     */
    public int getAvailableLots() {
        return AvailableLots;
    }

    /**
     * @param AvailableLots the AvailableLots to set
     */
    public void setAvailableLots(int AvailableLots) {
        this.AvailableLots = AvailableLots;
    }

    /**
     * @return String return the LotType
     */
    public String getLotType() {
        return LotType;
    }

    /**
     * @param LotType the LotType to set
     */
    public void setLotType(String LotType) {
        this.LotType = LotType;
    }

    /**
     * @return String return the Agency
     */
    public String getAgency() {
        return Agency;
    }

    /**
     * @param Agency the Agency to set
     */
    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    public double getLat() {
        String[] latLng = splitLocation();
        if (latLng.length != 2) {
            return 0;
        }
        String lat = latLng[0];
        return Double.parseDouble(lat);
    }

    public double getLng() {
        String[] latLng = splitLocation();
        if (latLng.length != 2) {
            return 0;
        }
        String lng = latLng[1];
        return Double.parseDouble(lng);
    }

    private String[] splitLocation() {
        return this.Location.split("\\s");
    } 

}