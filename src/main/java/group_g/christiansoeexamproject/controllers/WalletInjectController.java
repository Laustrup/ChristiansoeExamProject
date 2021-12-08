package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.repositories.*;
import group_g.christiansoeexamproject.utilities.Wallet;

public class WalletInjectController {

    private final Wallet wallet = Wallet.getWallet();

    public WalletInjectController(TourRepository tourRepo, LocationRepository locationRepo, AnimalRepository animalRepo,
                                  ImageRepository imageRepo, SoundRepository soundRepo) {
        wallet.injectRepos(tourRepo, locationRepo, animalRepo, imageRepo, soundRepo);
    }

}
