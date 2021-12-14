package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostInterfaceController {

    private final Wallet wallet = Wallet.getWallet();

    @GetMapping("/location")
    public ResponseEntity<Location> giveLocation(@RequestParam int id) {
        return new ResponseEntity<>(wallet.getLocation(id), HttpStatus.OK);
    }
}
