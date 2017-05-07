package com.workshop.myrecipe.myrecipes.ui.recipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.workshop.myrecipe.myrecipes.R;
import com.workshop.myrecipe.myrecipes.injection.InMemoryFavortite;
import com.workshop.myrecipe.myrecipes.injection.TestRecipeApplication;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

public class RecipeActivityTest {

    private InMemoryFavortite favortite;

    @Rule
    public ActivityTestRule<RecipeActivity> activityTestRule =
            new ActivityTestRule<>(
                    RecipeActivity.class,
                    true,
                    false);

    @Before
    public void clearAllFavorite(){
        TestRecipeApplication application =(TestRecipeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();
        favortite = (InMemoryFavortite) application.getFavorite();
        favortite.clear();
    }

    @Test public void
    found_receipe(){
        Intent intent = new Intent();
        intent.putExtra("id", "1");
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(withText("Title1")));
        onView(withId(R.id.description))
                .check(matches(withText("Description")));
    }

    @Test public void
    not_found_recipe() {
        activityTestRule.launchActivity(null);

        onView(withId(R.id.title))
                .check(matches(not(isDisplayed())));
        onView(withId(R.id.description))
                .check(matches(withText("Recipe not found")));
    }

    @Test public void
    click_to_favorite_recipe(){
        Intent intent = new Intent();
        intent.putExtra("id", "1");
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(withText("Title1")))
                .check(matches(not(isSelected())));

        onView(withId(R.id.title)).perform(click());

        onView(withId(R.id.title)).check(matches(isSelected()));
    }

    @Test public void
    already_favorited_recipe(){

    }


}