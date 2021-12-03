package group_g.christiansoeexamproject.controllers;


import group_g.christiansoeexamproject.models.Tour;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourInterfaceController {

    Wallet wallet;

    public TourInterfaceController(){

        //TODO: Needs to take wallet in parameter, when we figure out how
        //wallet = new Wallet();
    }

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> tourList(){

        List<Tour> response = wallet.getAllTours();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
