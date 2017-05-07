package com.workshop.myrecipe.myrecipes.ui.recipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.workshop.myrecipe.myrecipes.R;
import com.workshop.myrecipe.myrecipes.data.model.Recipe;
import com.workshop.myrecipe.myrecipes.injection.RecipeApplication;

public class RecipeActivity extends AppCompatActivity
implements RecipePresenter.RecipeView {

    private TextView titleTextView;
    private TextView descriptionTextView;
    private RecipeApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        titleTextView = (TextView)findViewById(R.id.title);
        descriptionTextView = (TextView)findViewById(R.id.description);

        application = (RecipeApplication) getApplication();

        final Intent intent = getIntent();

        //Step 1 :: Load recipe by id
        final RecipePresenter recipePresenter = new RecipePresenter(this, application.getFavorite());
        recipePresenter.loadData(intent.getStringExtra("id"));


        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipePresenter.toggle(intent.getStringExtra("id"));
            }
        });
    }

    @Override
    public void showRecipe(Recipe recipe){
        titleTextView.setText(recipe.getTitle());
        descriptionTextView.setText(recipe.getDescription());
    }

    @Override
    public void showRecipeNotFound(){
        titleTextView.setVisibility(View.GONE);
        descriptionTextView.setText("Recipe not found");
    }

    @Override
    public void showFavorite(boolean isFavorite) {
        titleTextView.setSelected(isFavorite);
    }
}
