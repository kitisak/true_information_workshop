package com.workshop.myrecipe.myrecipes.ui.recipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.workshop.myrecipe.myrecipes.R;
import com.workshop.myrecipe.myrecipes.data.local.RecipeStore;
import com.workshop.myrecipe.myrecipes.data.model.Recipe;
import com.workshop.myrecipe.myrecipes.injection.RecipeApplication;

public class RecipeActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        titleTextView = (TextView)findViewById(R.id.title);
        descriptionTextView = (TextView)findViewById(R.id.description);

        final RecipeApplication application = (RecipeApplication) getApplication();

        Intent intent = getIntent();
        RecipeStore store = new RecipeStore();
        final Recipe recipe = store.getRecipe(intent.getStringExtra("id"));
        if(recipe == null){
            titleTextView.setVisibility(View.GONE);
            descriptionTextView.setText("Recipe not found");
        } else {
            titleTextView.setText(recipe.getTitle());
            descriptionTextView.setText(recipe.getDescription());
            titleTextView.setSelected(application.getFavorite().get(recipe.getId()));
        }

        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recipe == null) {
                    throw new IllegalStateException("Must load before !!");
                }
                titleTextView.setSelected(application.getFavorite().toggle(recipe.getId()));
            }
        });
    }
}
