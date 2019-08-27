package app.carparksg.api.logic;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import app.carparksg.api.model.LtaAvailability;
import app.carparksg.api.model.LtaCarpark;

public class GetLtaCarpark {

    private final String url = "http://datamall2.mytransport.sg/ltaodataservice/CarParkAvailabilityv2";
    private final int maxResponsesPerApi = 500;
    private UriComponentsBuilder builder;
    private RestTemplate restTemplate;
    private HttpEntity<String> httpEntity;

    public GetLtaCarpark() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set("AccountKey", "fH3CTYBLyA7GhpvRrBtRag==");
        builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("$skip", 0);
        httpEntity = new HttpEntity<String>("parameters", httpHeaders);
        restTemplate = new RestTemplate();
    }

    public ArrayList<LtaCarpark> getAllLtaCarpark() {
        ArrayList<LtaCarpark> ltaCarparkList = new ArrayList<>();
        
        int skip = 0;
        LtaCarpark[] responses;

        do {
            responses = getLtaCarparkApi(skip);
            ltaCarparkList.addAll(Arrays.asList(responses));
            skip += responses.length;
        } while (responses.length == maxResponsesPerApi);
        
        return ltaCarparkList;
    }

    private LtaCarpark[] getLtaCarparkApi(int skip) {
        builder.replaceQueryParam("$skip", skip);
        String uri = builder.toUriString();
        ResponseEntity<LtaAvailability> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, LtaAvailability.class);
        LtaAvailability ltaAvailability = responseEntity.getBody();
        LtaCarpark[] responses = ltaAvailability.getValue();
        return responses; 
    }
    
    
}