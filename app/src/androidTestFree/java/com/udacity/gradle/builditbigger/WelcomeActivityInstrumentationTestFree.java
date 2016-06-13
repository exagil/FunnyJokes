package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.FlakyTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class WelcomeActivityInstrumentationTestFree {
    @Rule
    public ActivityTestRule<WelcomeActivity> welcomeActivityTestRule = new ActivityTestRule<>(WelcomeActivity.class);

    @Before
    public void setup() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testThatFreeFlavorShowsAdsOnWelcomeScreen() {
        onView(withContentDescription(R.string.container_ads_welcome)).check(matches(isDisplayed()));
    }

    @Test
    @FlakyTest
    public void testThatFreeFlavorShowsJokeAfterItDisplaysAnIterstetialAd() throws InterruptedException {
        onView(withText("Tell Joke")).perform(click());
        Thread.sleep(3000);
        onView(withContentDescription("Web View")).check(matches(isDisplayed()));
        intending(hasComponent("net.chiragaggarwal.jokedisplay.JokeDisplayActivity"));
    }
}
