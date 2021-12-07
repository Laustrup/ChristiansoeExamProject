package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Tour;
import group_g.christiansoeexamproject.repositories.TourRepository;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourInterfaceController {

    private Wallet wallet;

    public TourInterfaceController(TourRepository tourRepository){
        wallet = Wallet.getWallet();
        wallet.setTourRepo(tourRepository);
    }

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> tourList(){

        List<Tour> response = wallet.getAllTours();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
