package com.udacity.gradle.builditbigger.joke;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class JokeTest {
    @Test
    public void testThatJokeShouldNotBeEqualToNull() {
        Joke joke = new Joke("some_description");
        assertFalse(joke.equals(null));
    }

    @Test
    public void testThatJokeIsEqualToItself() {
        Joke joke = new Joke("some_description");
        assertEquals(joke, joke);
    }

    @Test
    public void testThatTwoJokesWithSameDescriptionsAreEqual() {
        Joke thisJoke = new Joke("some_description");
        Joke thatJoke = new Joke("some_description");
        assertEquals(thisJoke, thatJoke);
    }

    @Test
    public void testThatTwoJokesWithDifferentDescriptionsAreNotEqual() {
        Joke thisJoke = new Joke("some_description");
        Joke thatJoke = new Joke("some_other_description");
        assertNotEquals(thisJoke, thatJoke);
    }

    @Test
    public void testThatAJokeShouldNotBeEqualToAnythingOtherThanAJoke() {
        Joke thisJoke = new Joke("some_description");
        assertNotEquals(thisJoke, new Object());
    }

    @Test
    public void testThatTwoJokesEqualInBusinessContextShouldHaveTheSameHashCode() {
        Joke thisJoke = new Joke("some_description");
        Joke thatJoke = new Joke("some_description");
        assertEquals(thisJoke.hashCode(), thatJoke.hashCode());
    }
}
