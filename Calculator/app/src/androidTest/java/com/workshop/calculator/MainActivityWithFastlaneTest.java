package com.workshop.calculator;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityWithFastlaneTest {

    @ClassRule
    public static final LocaleTestRule localeTestRule
            = new LocaleTestRule();

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(
                    MainActivity.class,
                    true,
                    false);

    @BeforeClass
    public static void beforeAll() {
        Screengrab.setDefaultScreenshotStrategy(
                new UiAutomatorScreenshotStrategy());
    }

    @Test public void
    should_display_result_is_3(){
        activityTestRule.launchActivity(new Intent());

        Screengrab.screenshot("step_01");

        onView(withId(R.id.operand1))
                .perform(typeText("1"));

        onView(withId(R.id.operand2))
                .perform(typeText("2"), closeSoftKeyboard());

        Screengrab.screenshot("step_02");

        onView(withId(R.id.addButton))
                .perform(click());

        onView(withId(R.id.result))
                .check(matches(withText("3")));

        Screengrab.screenshot("step_03");
    }

}