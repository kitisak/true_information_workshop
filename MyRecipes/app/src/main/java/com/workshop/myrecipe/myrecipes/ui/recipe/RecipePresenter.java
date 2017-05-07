package com.workshop.myrecipe.myrecipes.ui.recipe;

import com.workshop.myrecipe.myrecipes.data.Favorite;
import com.workshop.myrecipe.myrecipes.data.local.RecipeStore;
import com.workshop.myrecipe.myrecipes.data.model.Recipe;

public class RecipePresenter {


    private final RecipeView recipeView;
    private final Favorite favorite;

    public RecipePresenter(RecipeView recipeView, Favorite favorite) {
        this.recipeView = recipeView;
        this.favorite = favorite;
    }

    interface RecipeView{
        void showRecipe(Recipe recipe);
        void showRecipeNotFound();
        void showFavorite(boolean isFavorite);
    }

    public void loadData(String id){
        RecipeStore store = new RecipeStore();
        final Recipe recipe = store.getRecipe(id);
        if(recipe == null){
            recipeView.showRecipeNotFound();
        } else {
            recipeView.showRecipe(recipe);
            recipeView.showFavorite(favorite.get(id));
        }
    }

    public void toggle(String id){
        recipeView.showFavorite(favorite.toggle(id));
    }


}
