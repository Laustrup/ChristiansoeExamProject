package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.Attraction;
import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.models.Tour;
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
            assertEquals(expected.getLocations().get(i),actual.getLocations().get(i));
        }


    }

}