package com.workshop.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test public void
    create_input_operand1_with_1_and_operand2_with2(){
        onView(withId(R.id.operand1))
        .perform(typeText("1"));

        onView(withId(R.id.operand2))
                .perform(typeText("2"));
    }

    @Test public void
    click_add_button(){
        onView(withId(R.id.operand1))
                .perform(typeText("1"));

        onView(withId(R.id.operand2))
                .perform(typeText("2"));

        onView(withId(R.id.addButton))
        .perform(click());
    }

    @Test public void
    should_display_result_is_3(){
        onView(withId(R.id.operand1))
                .perform(typeText("1"));

        onView(withId(R.id.operand2))
                .perform(typeText("2"));

        onView(withId(R.id.addButton))
                .perform(click());

        onView(withId(R.id.result))
                .check(matches(withText("3")));
    }

}