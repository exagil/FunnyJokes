package com.udacity.gradle.builditbigger.joke;

public class Joke {
    public final String someJokeDescription;

    public Joke(String someJokeDescription) {
        this.someJokeDescription = someJokeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || !(o instanceof Joke)) return false;
        Joke thatJoke = (Joke) o;
        if (this.someJokeDescription.equals(thatJoke.someJokeDescription)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return someJokeDescription != null ? someJokeDescription.hashCode() : 0;
    }
}
