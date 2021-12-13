package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.Attraction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ptest {
    private Wallet wallet;

    @Test
    public void whyIsThereAnAnimal(){
        wallet = Wallet.getWallet();

        Attraction a = (Attraction) wallet.getLocation(1);
        System.out.println(a.getAnimals().get(0).getImages().get(0));
    }
}
