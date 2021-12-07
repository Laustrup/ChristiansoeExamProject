package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.repositories.ImageRepository;
import group_g.christiansoeexamproject.repositories.SoundRepository;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.web.bind.annotation.RestController;

/*
    Only purpose of this controller is to initialise the remaining
    repositories in the wallet of image and sound.
    In case any other responsibilities of sound and images as a controller,
    this controller will have that responsibility.

 */

@RestController
public class MediaController {

    private Wallet wallet;

    public MediaController(ImageRepository imageRepo, SoundRepository soundRepo) {
        wallet = Wallet.getWallet();
        wallet.setImageRepo(imageRepo);
        wallet.setSoundRepo(soundRepo);
    }
}
