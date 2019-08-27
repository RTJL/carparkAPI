package app.carparksg.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import app.carparksg.api.model.Carpark;
import app.carparksg.api.model.CarparkDAO;
import app.carparksg.api.ErrorResponse;

@RestController
public class CarparkController {

    private CarparkDAO carparkDAO;

    public CarparkController() {
        carparkDAO = CarparkDAO.getInstance();
    }

    @RequestMapping(value = "/carparks", method=RequestMethod.GET)
    public ResponseEntity<?> carpark() {
        List<Carpark> allCarparks = carparkDAO.getAllCarpark();
        if (allCarparks.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse("No carparks available");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allCarparks, HttpStatus.OK);
    }

    @RequestMapping(value="/carparks/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> carpark(@PathVariable(value = "id", required = true) String id) {
        Optional<Carpark> carpark = carparkDAO.getCarpark(id);

        if (id.equalsIgnoreCase("") || !carpark.isPresent()) {
            ErrorResponse errorResponse = new ErrorResponse("ID not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
         
        return new ResponseEntity<>(carpark.get(), HttpStatus.OK);        
    }
}