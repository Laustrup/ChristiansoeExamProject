package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.*;
import group_g.christiansoeexamproject.repositories.*;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WalletTest {

    private Wallet wallet;

    @Autowired
    TourRepository tourRepo;
    @Autowired
    LocationRepository locationRepo;
    @Autowired
    AnimalRepository animalRepo;
    @Autowired
    ImageRepository imageRepo;
    @Autowired
    SoundRepository soundRepo;

    @BeforeEach
    public void beforeEach() {
        wallet = Wallet.getWallet();
        wallet.injectRepos(tourRepo,locationRepo,animalRepo,imageRepo,soundRepo);
    }


//TODO: Denne test skaber problemer, ift. "failed to lazily initialize a collection of role...". Skal fikses.

    @ParameterizedTest
    @CsvSource(value = "Fra vest til øst|Denne tur er fra vest til øst!|Danmarks østligeste punkt_Badebro",delimiter = '|')
    public void tourTest(String expectedTitle, String expectedReport, String expectedLocations) {
        // Arrange
        String[] locations = expectedLocations.split("_");
        LinkedList<Location> listOfLocations = new LinkedList();
        for (int i = 0; i < locations.length;i++) {
            listOfLocations.add((Location)wallet.getObject(locations[i]));
        }

        Tour expected = new Tour(expectedTitle,expectedReport,listOfLocations);

        // Act
        Tour actual = (Tour)wallet.getObject(expectedTitle);

        // Assert
        assertEquals(true,wallet.doesExist(expected.getTitle()));
        assertEquals(expected.getReport(), actual.getReport());

        for (int i = 0; i < expected.getLocations().size(); i++) {
            //TODO: den laver Failed to lazily initialize.. for "locations" og derfor kan actual ikke få en titel.
             assertEquals(expected.getLocations().get(i).getTitle(),actual.getLocations().get(i).getTitle());
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"Danmarks østligeste punkt|Du kan ikke finde et andet punkt i Danmark der er mere østligt end dette!|" +
                        "15.192853298391688|55.32029540616608|Sæl billede|" +
                        "Sæl|Sæl hyl lyd",

                        "Badebro|Dette er en badebro!|15.183442624715434|55.32128710201616||" +
                        "Sæl|"}, delimiter = '|')
    public void locationTest(String expectedTitle, String expectedReport, double longitude, double latitude,
                             String expectedImages, String expectedAnimals, String expectedSounds) {
        // Arrange
        LinkedList<Image> listOfImages = new LinkedList();
        LinkedList<Animal> listOfAnimals = new LinkedList();
        LinkedList<Sound> listOfSounds = new LinkedList();

        if (expectedImages!=null) {
            String[] images = expectedImages.split("_");
            for (int i = 0; i < images.length; i++) {
                listOfImages.add((Image)wallet.getObject(images[i]));
            }
        }

        String[] animals = expectedAnimals.split("_");
        for (int i = 0; i < animals.length; i++) {
            listOfAnimals.add((Animal)wallet.getObject(animals[i]));
        }


        if (expectedSounds!=null) {
            String[] sounds = expectedSounds.split("_");
            for (int i = 0; i < sounds.length; i++) {
                listOfSounds.add((Sound)wallet.getObject(sounds[i]));
            }
        }

        Attraction expected = new Attraction(expectedTitle,expectedReport,longitude,latitude,
                                            listOfAnimals,listOfImages, listOfSounds);

        // Act
        Attraction actual = (Attraction) wallet.getObject(expectedTitle);

        // Assert
        assertEquals(true, wallet.doesExist(expected.getTitle()));
        assertEquals(expected.getReport(), actual.getReport());
        assertEquals(expected.getLongitude(), actual.getLongitude());
        assertEquals(expected.getLatitude(), actual.getLatitude());

        for (int i = 0; i < expected.getAnimals().size(); i++) {
            assertEquals(expected.getAnimals().get(i).getTitle(), actual.getAnimals().get(i).getTitle());
        }
        for (int i = 0; i < expected.getSounds().size(); i++) {
            assertEquals(expected.getSounds().get(i).getFilePath(), actual.getSounds().get(i).getFilePath());
        }
        for (int i = 0; i < expected.getImages().size(); i++) {
            assertEquals(expected.getImages().get(i).getFilePath(), actual.getImages().get(i).getFilePath());
        }
    }

    @ParameterizedTest
    @CsvSource(value = "Sæl billede|.../static/images/seal.jpeg",delimiter = '|')
    public void imageTest(String expectedTitle,String expectedFilePath) {
        // Arrange
        Image expected = new Image(expectedTitle,expectedFilePath);

        // Act
        Image act = (Image) wallet.getObject(expectedTitle);

        // Assert
        assertEquals(expected.getTitle(),act.getTitle());
        assertEquals(expected.getFilePath(),act.getFilePath());

    }

    @ParameterizedTest
    @CsvSource(value = "Sæl hyl lyd|.../static/sounds/seal.wav",delimiter = '|')
    public void soundTest(String expectedTitle,String expectedFilePath) {
        // Arrange
        Sound expected = new Sound(expectedTitle,expectedFilePath);

        // Act
        Sound act = (Sound) wallet.getObject(expectedTitle);

        // Assert
        assertEquals(expected.getTitle(),act.getTitle());
        assertEquals(expected.getFilePath(),act.getFilePath());

    }
}