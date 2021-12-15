package group_g.christiansoeexamproject.config;


import group_g.christiansoeexamproject.repositories.*;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletSetup implements CommandLineRunner {

    private TourRepository tourRepo;
    private LocationRepository locationRepo;
    private AnimalRepository animalRepo;
    private ImageRepository imageRepo;
    private SoundRepository soundRepo;
    private TourLocationRepository tourLocationRepository;

    public WalletSetup(TourRepository tourRepo, LocationRepository locationRepo, AnimalRepository animalRepo,
                                  ImageRepository imageRepo, SoundRepository soundRepo, TourLocationRepository tourLocationRepository) {

        this.tourRepo = tourRepo;
        this.locationRepo = locationRepo;
        this.animalRepo = animalRepo;
        this.imageRepo = imageRepo;
        this.soundRepo = soundRepo;
        this.tourLocationRepository = tourLocationRepository;
    }

    @Override
    public void run(String... args){
        Wallet.injectRepos(tourRepo, locationRepo, animalRepo, imageRepo, soundRepo, tourLocationRepository);
    }
}
