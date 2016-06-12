package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class WelcomeActivityTest {
    @Rule
    public ActivityTestRule<WelcomeActivity> welcomeActivityTestRule = new ActivityTestRule<WelcomeActivity>(WelcomeActivity.class, true, false);

    @Before
    public void setup() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testThatJokeScreenIsLaunchedWhenJokeIsSuccessfullyFetched() {
        welcomeActivityTestRule.launchActivity(null);
        onView(withText("Tell Joke")).perform(click());
        intending(hasComponent("net.chiragaggarwal.jokedisplay.JokeDisplayActivity"));
    }

    @Test
    public void testThatJokeIsDisplayedWhenJokeIsSuccessfullyFetched() throws InterruptedException {
        welcomeActivityTestRule.launchActivity(null);
        onView(withText("Tell Joke")).perform(click());
        Thread.sleep(2000);
        onView(withId(net.chiragaggarwal.jokedisplay.R.id.text_joke)).check(matches(isDisplayed()));
    }
}
