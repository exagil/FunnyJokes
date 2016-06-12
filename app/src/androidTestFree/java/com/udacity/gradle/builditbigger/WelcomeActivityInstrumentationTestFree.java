package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;

@RunWith(AndroidJUnit4.class)
public class WelcomeActivityInstrumentationTestFree {
    @Rule
    public ActivityTestRule<WelcomeActivity> welcomeActivityTestRule = new ActivityTestRule<WelcomeActivity>(WelcomeActivity.class);

    @Test
    public void testThatFreeFlavorShowsAdsOnWelcomeScreen() {
        onView(withContentDescription(R.string.container_ads_welcome)).check(matches(isDisplayed()));
    }
}
