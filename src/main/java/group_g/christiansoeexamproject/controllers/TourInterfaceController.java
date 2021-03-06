package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.models.Tour;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourInterfaceController {

    private final Wallet wallet = Wallet.getWallet();

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> listOfTours(){
        return new ResponseEntity<>(wallet.getAllTours(), HttpStatus.OK);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> giveLocations(){
        return new ResponseEntity<>(wallet.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/tour/{id}")
    public ResponseEntity<Tour> giveTour(@PathVariable int id) {
        return new ResponseEntity<>(wallet.getTour(id),HttpStatus.OK);
    }

    @GetMapping("/tourLocations/{id}")
    public ResponseEntity<List<Location>> giveTourLocations(@PathVariable int id){
        return new ResponseEntity<>(wallet.getTourLocations(id),HttpStatus.OK);
    }
}
