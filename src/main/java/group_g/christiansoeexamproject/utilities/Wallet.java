package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.models.Tour;
import group_g.christiansoeexamproject.repositories.LocationRepository;
import group_g.christiansoeexamproject.repositories.TourRepository;

import java.util.*;

public class Wallet {

    private Map<String, Object> inbox;

    private TourRepository tourRepo;
    private LocationRepository locationRepo;

    public Wallet(TourRepository tourRepo,LocationRepository locationRepo) {
        this.tourRepo = tourRepo;
        this.locationRepo = locationRepo;
        inbox = new HashMap<>();
        update();
    }

    public Wallet(TourRepository tourRepo,LocationRepository locationRepo, Map<String,Object> typeOfInbox) {
        this.tourRepo = tourRepo;
        this.locationRepo = locationRepo;
        inbox = typeOfInbox;
        update();
    }

    // Updates the inbox - Needs connection for the database
    public Map<String, Object> update() {
        inbox.clear();

        List<Tour> tours = tourRepo.findAll();
        List<Location> locations = locationRepo.findAll();

        // Puts the lists in the inbox as lists for iterable purposes
        inbox.put("Tours",tours);
        inbox.put("Locations",locations);

        // Puts the lists from the database into the inbox as keys from the objects titles
        for (int i = 0; i < tours.size();i++) {
            inbox.put(tours.get(i).getTitle(),tours.get(i));
        }
        for (int i = 0; i < locations.size();i++) {
            inbox.put(locations.get(i).getTitle(),locations.get(i));
        }

        return inbox;
    }

    public Object getObject(String key) {
        return inbox.get(key);
    }

    // Returns true if key exists and replaces the key's value with method's value parameter
    public boolean replace(String key, Object value) {
        if (inbox.containsKey(key)) {
            inbox.replace(key, value);
            return true;
        }
        return false;
    }

    public Map<String, Object> putIn(String key, Object value) {
        inbox.put(key, value);
        return inbox;
    }

    // Returns all tours
    public List<Tour> getAllTours() {
        return (List<Tour>) inbox.get("Tours");
    }

    // Returns all locations
    public List<Location> getAllLocations() {
        return (List<Location>) inbox.get("Locations");
    }

    public boolean has(Object value) {
        return inbox.containsValue(value);
    }

    public boolean has(String key) {
        return inbox.containsKey(key);
    }

    // returns true if inbox contains key input and will remove its value
    public boolean delete(String key) {
        if (inbox.containsKey(key)) {
            inbox.remove(key);
            return true;
        }
        return false;
    }

    public boolean doesExist(Object object) {
        return inbox.containsValue(object);
    }
    public boolean doesExist(String key) {
        return inbox.containsKey(key);
    }

}
