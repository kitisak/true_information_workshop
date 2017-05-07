package com.workshop.myrecipe.myrecipes.data.local;


import com.workshop.myrecipe.myrecipes.data.model.Recipe;

public class RecipeStore {

    public Recipe get(int position) {
        return new Recipe(""+ position, "Title" + position, "Description");
    }

    public int size() {
        return 20;
    }

    public Recipe getRecipe(String id) {
        if(id == null) {
            return null;
        }
        return new Recipe(id, "Title" + id, "Description");
    }
}
