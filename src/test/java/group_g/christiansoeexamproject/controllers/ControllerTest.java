package group_g.christiansoeexamproject.controllers;

import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.repositories.*;
import group_g.christiansoeexamproject.utilities.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ControllerTest {

    private Wallet wallet;
    private PostInterfaceController postInterfaceController = new PostInterfaceController();

    @Autowired
    private TourRepository tourRepo;
    @Autowired
    private LocationRepository locationRepo;
    @Autowired
    private AnimalRepository animalRepo;
    @Autowired
    private ImageRepository imageRepo;
    @Autowired
    private SoundRepository soundRepo;
    @Autowired
    private TourLocationRepository tourLocationRepo;

    @BeforeEach
    public void beforeEach() {
        wallet = Wallet.getWallet();
        wallet.injectRepos(tourRepo,locationRepo,animalRepo,imageRepo,soundRepo,tourLocationRepo);
    }

    @ParameterizedTest
    @CsvSource(value = {"1","2"},delimiter = '|')
    public void locationTest(int id) {
        // Arrange
        Location expected = wallet.getLocation(id);

        // Act
        ResponseEntity<Location> actual = postInterfaceController.giveLocation(id);

        // Assert
        assertThat(actual.getStatusCodeValue()).isEqualTo(200);
        assertThat(actual.getBody().getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getBody().getId()).isEqualTo(expected.getId());
    }
}