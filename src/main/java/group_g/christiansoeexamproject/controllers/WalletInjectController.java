package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.repositories.*;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletInjectController {


    public WalletInjectController(TourRepository tourRepo, LocationRepository locationRepo, AnimalRepository animalRepo,
                                  ImageRepository imageRepo, SoundRepository soundRepo) {
        //Wallet.injectRepos(tourRepo, locationRepo, animalRepo, imageRepo, soundRepo);
    }

}
