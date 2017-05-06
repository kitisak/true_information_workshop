package com.workshop.calculator;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class ResultActivityTest {

    @Rule
    public ActivityTestRule<ResultActivity> activityTestRule
            = new ActivityTestRule<>(
                    ResultActivity.class,
                    false,
                    false);

    @Test public void
    show_result_15  (){
        Intent intent = new Intent();
        intent.putExtra("result", "15");
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.result))
                .check(matches(withText("15")));

    }

}