package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.repositories.LocationRepository;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostInterfaceController {

    private final Wallet wallet;

    public PostInterfaceController(LocationRepository locationRepo){
        wallet = Wallet.getWallet();
        wallet.setLocationRepo(locationRepo);
    }

    @GetMapping("/location?={id}")
    public ResponseEntity<Location> giveLocation(@PathVariable (name = "id") String id) {
        return new ResponseEntity<>((Location) wallet.getObject(id), HttpStatus.OK);
    }
}
