package com.workshop.myrecipe.myrecipes.data.local;


import android.content.Context;
import android.content.SharedPreferences;

import com.workshop.myrecipe.myrecipes.data.Favorite;

public class SharedPreferencesFavorites implements Favorite {
    private final SharedPreferences pref;

    public SharedPreferencesFavorites(Context context) {
        pref = context.getSharedPreferences("favorite"
                , Context.MODE_PRIVATE);
    }

    @Override
    public boolean get(String id) {
        return pref.getBoolean(id, false);
    }

    @Override
    public boolean toggle(String id) {
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }

    private void put(String id, boolean favorite) {
        SharedPreferences.Editor editor = pref.edit();
        if (favorite) {
            editor.putBoolean(id, true);
        } else {
            editor.remove(id);
        }
        editor.apply();
    }
}
