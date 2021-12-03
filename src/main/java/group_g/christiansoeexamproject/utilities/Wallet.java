package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.Tour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {

    private Map<String, Object> map = new HashMap<>();

    public Object getMap(String key) {
        return map.get(key);
    }

    public void setMap(String key, Object value) {
        map.replace(key, value);
    }

    public Map<String, Object> putInMap(String key, Object value) {
        map.put(key, value);
        return map;
    }

    // Returns all tours
    public List<Tour> getAllTours() {
        List<Tour> tours = new ArrayList<>();

        return tours;
    }

    public void has(Object value) {
        map.containsValue(value);
    }

    public void has(String key) {
        map.containsKey(key);
    }

    public void delete(String key) {
        map.remove(key);
    }

}
