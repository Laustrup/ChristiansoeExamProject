package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.Attraction;
import group_g.christiansoeexamproject.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ptest {
    private Wallet wallet;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private SoundRepository soundRepository;
    @Autowired
    private TourRepository tourRepository;

    @Test
    public void whyIsThereAnAnimal(){

        wallet = Wallet.getWallet();
        Wallet.injectRepos(tourRepository, locationRepository,animalRepository, imageRepository, soundRepository);

        Attraction a = (Attraction) wallet.getLocation(1);
        System.out.println(a.getAnimals().get(0).getImages().get(0));
    }
}
