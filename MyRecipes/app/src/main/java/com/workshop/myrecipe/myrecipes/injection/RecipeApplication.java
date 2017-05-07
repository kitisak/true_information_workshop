package com.workshop.myrecipe.myrecipes.injection;

import android.app.Application;

import com.workshop.myrecipe.myrecipes.data.Favorite;
import com.workshop.myrecipe.myrecipes.data.local.SharedPreferencesFavorites;

public class RecipeApplication extends Application {

    private Favorite favorite = null;

    public Favorite getFavorite() {
        if(favorite == null){
            favorite = new SharedPreferencesFavorites(this);
        }
        return favorite;
    }

}
