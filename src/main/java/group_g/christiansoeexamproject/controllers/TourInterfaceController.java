package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.models.Tour;
import group_g.christiansoeexamproject.repositories.TourRepository;
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
    public ResponseEntity<List<Location>> tourLocations(){
        return new ResponseEntity<>(wallet.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/tour?={id}")
    public ResponseEntity<Tour> giveTour(@PathVariable (name="id") int id) {
        return new ResponseEntity<>(wallet.getTour(id),HttpStatus.OK);
    }

}
