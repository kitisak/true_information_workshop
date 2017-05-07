package com.workshop.myrecipe.myrecipes.data.model;

public class Recipe {

    private String id;
    private String title;
    private String description;

    public Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
