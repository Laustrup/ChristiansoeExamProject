package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.*;
import group_g.christiansoeexamproject.repositories.*;

import java.util.*;

public class Wallet {

    private static Wallet wallet;

    public static Wallet getWallet(){
        if(wallet == null){
            wallet = new Wallet();
        }
        return wallet;
    }

    private Map<String, Object> inventory;

    private TourRepository tourRepo;
    private LocationRepository locationRepo;
    private AnimalRepository animalRepo;
    private ImageRepository imageRepo;
    private SoundRepository soundRepo;

    public Wallet() {
        inventory = new HashMap<>();
    }

    public void setTourRepo(TourRepository tourRepo){
        this.tourRepo = tourRepo;
        doUpdate();
    }
    public void setLocationRepo(LocationRepository locationRepo){
        this.locationRepo = locationRepo;
        doUpdate();
    }
    public void setAnimalRepo(AnimalRepository animalRepo){
        this.animalRepo = animalRepo;
        doUpdate();
    }
    public void setImageRepo(ImageRepository imageRepo){
        this.imageRepo = imageRepo;
        doUpdate();
    }
    public void setSoundRepo(SoundRepository soundRepo){
        this.soundRepo = soundRepo;
        doUpdate();
    }

    private void doUpdate() {
        if (!(tourRepo==null||locationRepo==null||animalRepo==null||imageRepo==null||soundRepo==null)) {
            update();
        }
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
            inventory.put(String.valueOf(tours.get(i).getId()),tours.get(i));
        }
        for (int i = 0; i < locations.size();i++) {
            inventory.put(String.valueOf(locations.get(i).getId()),locations.get(i));
        }
        for (int i = 0; i < animals.size();i++) {
            inventory.put(String.valueOf(animals.get(i).getId()),animals.get(i));
        }
        for (int i = 0; i < images.size();i++) {
            inventory.put(String.valueOf(images.get(i).getId()),images.get(i));
        }
        for (int i = 0; i < sounds.size();i++) {
            inventory.putIfAbsent(String.valueOf(sounds.get(i).getId()),sounds.get(i));
        }

        return inventory;
    }

    public Object getObject(String key) {
        return inventory.get(key);
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
