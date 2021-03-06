package com.workshop.myrecipe.myrecipes.injection;

import com.workshop.myrecipe.myrecipes.data.Favorite;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFavortite implements Favorite {
    private Map<String, Boolean> values = new HashMap<>();

    @Override
    public boolean get(String id) {
        Boolean value = values.get(id);
        return value == null ? false : value;
    }

    @Override
    public boolean toggle(String id) {
        boolean value = get(id);
        values.put(id, !value);
        return !value;
    }

    public void put(String id, boolean value) {
        values.put(id, value);
    }

    public void clear() {
        values.clear();
    }
}
