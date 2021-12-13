package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.*;
import group_g.christiansoeexamproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

public class Wallet {

    private static Wallet wallet;

    public static Wallet getWallet(){
        if(wallet == null){
            wallet = new Wallet();
        }
        return wallet;
    }

    private final Map<String, Object> inventory = new HashMap<>();

    private TourRepository tourRepo;
    private LocationRepository locationRepo;
    private AnimalRepository animalRepo;
    private ImageRepository imageRepo;
    private SoundRepository soundRepo;

    public static void injectRepos(TourRepository tourRepo,LocationRepository locationRepo,AnimalRepository animalRepo,
                       ImageRepository imageRepo, SoundRepository soundRepo) {

        wallet.tourRepo = tourRepo;
        wallet.locationRepo = locationRepo;
        wallet.animalRepo = animalRepo;
        wallet.imageRepo = imageRepo;
        wallet.soundRepo = soundRepo;
        wallet.update();
    }

    // Updates the inbox - Needs connection for the database
    public Map<String, Object> update() {
        inventory.clear();

        // Puts all objects into lists
        List<Tour> tours = tourRepo.findAll();
        List<Location> locations = locationRepo.findAll();
        List<Animal> animals = animalRepo.findAll();
        List<Image> images = imageRepo.findAll();
        List<Sound> sounds = soundRepo.findAll();

        // Puts the lists in the inbox as lists for iterable purposes
        inventory.put("Tours",tours);
        inventory.put("Locations",locations);

        // Puts the lists from the database into the inbox as keys from the objects titles
        for (int i = 0; i < tours.size();i++) {
            inventory.put("Tour id: "+tours.get(i).getId(),tours.get(i));
            inventory.put(tours.get(i).getTitle(),tours.get(i));
        }
        for (int i = 0; i < locations.size();i++) {
            inventory.put("Location id: "+locations.get(i).getId(),locations.get(i));
            inventory.put(locations.get(i).getTitle(),locations.get(i));
        }
        for (int i = 0; i < animals.size();i++) {
            inventory.put("Animal id: "+animals.get(i).getId(),animals.get(i));
            inventory.put(animals.get(i).getTitle(),animals.get(i));
        }
        for (int i = 0; i < images.size();i++) {
            inventory.put("Image id: "+(images.get(i).getId()),images.get(i));
            inventory.put(images.get(i).getTitle(),images.get(i));
        }
        for (int i = 0; i < sounds.size();i++) {
            inventory.put("Sound id: "+sounds.get(i).getId(),sounds.get(i));
            inventory.put(sounds.get(i).getTitle(),sounds.get(i));
        }

        return inventory;
    }

    public Object getObject(String key) {
        return inventory.get(key);
    }
    public Tour getTour(int id) {
        return (Tour) inventory.get("Tour id: "+id);
    }
    public Location getLocation(int id) {

        return (Location) inventory.get("Location id: " + id);
    }

    // Returns true if key exists and replaces the key's value with method's value parameter
    public boolean replace(String key, Object value) {
        if (inventory.containsKey(key)) {
            inventory.replace(key, value);
            return true;
        }
        return false;
    }

    public Map<String, Object> putIn(String key, Object value) {
        inventory.put(key, value);
        return inventory;
    }

    // Returns all tours
    public List<Tour> getAllTours() {
        return (List<Tour>) inventory.get("Tours");
    }

    // Returns all locations
    public List<Location> getAllLocations() {
        return (List<Location>) inventory.get("Locations");
    }

    public boolean has(Object value) {
        return inventory.containsValue(value);
    }

    public boolean has(String key) {
        return inventory.containsKey(key);
    }

    // returns true if inbox contains key input and will remove its value
    public boolean delete(String key) {
        if (inventory.containsKey(key)) {
            inventory.remove(key);
            return true;
        }
        return false;
    }

    public boolean doesExist(Object object) {
        return inventory.containsValue(object);
    }
    public boolean doesExist(String key) {
        return inventory.containsKey(key);
    }

}
