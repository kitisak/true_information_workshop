package com.workshop.myrecipe.myrecipes.data;

public interface Favorite {
    boolean get(String id);
    boolean toggle(String id);
}
