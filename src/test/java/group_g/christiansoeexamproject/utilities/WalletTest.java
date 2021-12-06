package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.*;
import group_g.christiansoeexamproject.repositories.LocationRepository;
import group_g.christiansoeexamproject.repositories.TourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.List;

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
        LinkedList<Sound> listOfSounds = new LinkedList();
        for (int i = 0; i < sounds.length;i++) {
            listOfSounds.add((Sound)wallet.getObject(sounds[i]));
        }

        Attraction expected = new Attraction(expectedTitle,expectedReport,longitude,latitude,
                                            listOfAnimals,listOfSounds,listOfImages);

        // Act
        Attraction actual = (Attraction) wallet.getObject(expectedTitle);

        // Assert
        assertEquals(true,wallet.doesExist(expected.getTitle()));
        assertEquals(expected.getReport(),actual.getReport());
        assertEquals(expected.getLongitude(),actual.getLongitude());
        assertEquals(expected.getLatitude(),actual.getLatitude());

        for (int i = 0; i < expected.getAnimals().size();i++) {
            assertEquals(expected.getAnimals().get(i).getTitle(),actual.getAnimals().get(i).getTitle());
        }
        for (int i = 0; i < expected.getSounds().size();i++) {
            assertEquals(expected.getSounds().get(i).getFilePath(),actual.getSounds().get(i).getFilePath());
        }
        for (int i = 0; i < expected.getImages().size();i++) {
            assertEquals(expected.getImages().get(i).getFilePath(),actual.getImages().get(i).getFilePath());
        }
    }

}