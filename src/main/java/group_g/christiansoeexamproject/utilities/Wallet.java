package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.Location;
import group_g.christiansoeexamproject.models.Tour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {

    private Map<String, Object> inbox = new HashMap<>();

    // updates
    public Map<String, Object> update() {



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
        List<Tour> tours = new ArrayList<>();

        for (int i = 0; i < inbox.size(); i++) {
            if (inbox.containsKey("Tour"+i+1)) {tours.add((Tour) inbox.get("Tour"+i+1));}
        }

        return tours;
    }

    // Returns all locations
    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();

        for (int i = 0; i < inbox.size(); i++) {
            if (inbox.containsKey("Location"+i+1)) {locations.add((Location) inbox.get("Location"+i+1));}
        }

        return locations;
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

}
