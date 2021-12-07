package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.Image;
import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.models.Sound;
import group_g.christiansoeexamproject.models.Tour;
import group_g.christiansoeexamproject.repositories.ImageRepository;
import group_g.christiansoeexamproject.repositories.LocationRepository;
import group_g.christiansoeexamproject.repositories.SoundRepository;
import group_g.christiansoeexamproject.repositories.TourRepository;

import java.util.*;

public class Wallet {

    private Map<String, Object> inventory;

    private TourRepository tourRepo;
    private LocationRepository locationRepo;
    private ImageRepository imageRepo;
    private SoundRepository soundRepo;

    public Wallet(TourRepository tourRepo,LocationRepository locationRepo,
                  ImageRepository imageRepo,SoundRepository soundRepo) {

        this.tourRepo = tourRepo;
        this.locationRepo = locationRepo;
        this.imageRepo = imageRepo;
        this.soundRepo = soundRepo;

        inventory = new HashMap<>();
        update();
    }

    // Updates the inbox - Needs connection for the database
    public Map<String, Object> update() {
        inventory.clear();

        // Puts all objects into lists
        List<Tour> tours = tourRepo.findAll();
        List<Location> locations = locationRepo.findAll();
        List<Image> images = imageRepo.findAll();
        List<Sound> sounds = soundRepo.findAll();

        // Puts the lists in the inbox as lists for iterable purposes
        inventory.put("Tours",tours);
        inventory.put("Locations",locations);

        // Puts the lists from the database into the inbox as keys from the objects titles
        for (int i = 0; i < tours.size();i++) {
            inventory.put(tours.get(i).getTitle(),tours.get(i));
        }
        for (int i = 0; i < locations.size();i++) {
            inventory.put(locations.get(i).getTitle(),locations.get(i));
        }
        for (int i = 0; i < images.size();i++) {
            inventory.put(images.get(i).getTitle(),images.get(i));
        }
        for (int i = 0; i < sounds.size();i++) {
            inventory.putIfAbsent(sounds.get(i).getTitle(),sounds.get(i));
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
