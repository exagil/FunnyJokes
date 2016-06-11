package com.udacity.gradle.builditbigger.joke;

import com.google.gson.annotations.SerializedName;

public class Joke {
    @SerializedName("jokeDescription")
    public final String description;

    public Joke(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || !(o instanceof Joke)) return false;
        Joke thatJoke = (Joke) o;
        if (this.description.equals(thatJoke.description)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }
}
