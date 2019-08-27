package app.carparksg.api.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LtaAvailability {

    @JsonProperty("odata.metadata")
    private String odataMetadata;

    public LtaCarpark[] value;

    public LtaAvailability() {
    }

    /**
     * @return String return the odataMetadata
     */
    public String getOdataMetadata() {
        return odataMetadata;
    }

    /**
     * @param odataMetadata the odataMetadata to set
     */
    public void setOdataMetadata(String odataMetadata) {
        this.odataMetadata = odataMetadata;
    }

    /**
     * @return LtaCarpark[] return the value
     */
    public LtaCarpark[] getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(LtaCarpark[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        
        return "LTAAvailability{" +
            "odata.metadata='" + odataMetadata + "\'" +
            ", value=" + Arrays.toString(value) + 
            "}";
    }

}