package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.*;
import group_g.christiansoeexamproject.repositories.LocationRepository;
import group_g.christiansoeexamproject.repositories.TourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    private Wallet wallet;
    private TourRepository tourRepo;
    private LocationRepository locationRepo;

    // Constructor created for injection repositories.
    public WalletTest(TourRepository tourRepo,LocationRepository locationRepo) {
        this.tourRepo = tourRepo;
        this.locationRepo = locationRepo;
    }

    @BeforeEach
    public void beforeEach() {
        wallet = new Wallet(tourRepo,locationRepo);
    }

    @ParameterizedTest
    @CsvSource(value = "Fra vest til øst,Denne tur er fra vest til øst!,Danmarks østligeste punkt_Badebro",delimiter = '|')
    public void tourTest(String expectedTitle, String expectedReport, String expectedLocations) {
        // Arrange
        String[] locations = expectedLocations.split("_");
        LinkedList<Location> listOfLocations = new LinkedList();
        for (int i = 0; i < locations.length;i++) {
            listOfLocations.add((Location)wallet.getObject(locations[i]));
        }

        Tour expected = new Tour(expectedTitle,expectedReport,listOfLocations);

        // Act
        Tour actual = (Tour)wallet.getObject(expected.getTitle());

        // Assert
        assertEquals(true,wallet.doesExist(expected.getTitle()));
        assertEquals(expected.getReport(),actual.getReport());

        for (int i = 0; i < expected.getLocations().size();i++) {
            assertEquals(expected.getLocations().get(i).getTitle(),actual.getLocations().get(i).getTitle());
        }
    }

    @ParameterizedTest
    @CsvSource(value = "", delimiter = '|')
    public void locationTest(String expectedTitle, String expectedReport,
                             double longitude, double latitude,
                             String expectedImages, String expectedAnimals, String expectedSounds) {
        // Arrange
        String[] images = expectedImages.split("_");
        LinkedList<Image> listOfImages = new LinkedList();
        for (int i = 0; i < images.length;i++) {
            listOfImages.add((Image)wallet.getObject(images[i]));
        }
        String[] animals = expectedAnimals.split("_");
        LinkedList<Animal> listOfAnimals = new LinkedList();
        for (int i = 0; i < animals.length;i++) {
            listOfAnimals.add((Animal)wallet.getObject(animals[i]));
        }
        String[] sounds = expectedSounds.split("_");
        LinkedList<Sound> listOfSound = new LinkedList();
        for (int i = 0; i < sounds.length;i++) {
            listOfSound.add((Sound)wallet.getObject(sounds[i]));
        }

        Location expected = new Attraction(expectedTitle,expectedReport,longitude,latitude,listOfAnimals,listOfSound,listOfImages);

        // Act
        Location actual = (Attraction) wallet.getObject(expectedTitle);

        // Assert
        assertEquals(true,wallet.doesExist(expected.getTitle()));

    }

}