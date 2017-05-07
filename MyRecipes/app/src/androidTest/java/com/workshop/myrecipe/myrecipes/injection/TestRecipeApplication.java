package com.workshop.myrecipe.myrecipes.injection;


import com.workshop.myrecipe.myrecipes.data.Favorite;

public class TestRecipeApplication extends RecipeApplication {

    private final Favorite favorite = new InMemoryFavortite();

    @Override
    public Favorite getFavorite() {
        return favorite;
    }
}
