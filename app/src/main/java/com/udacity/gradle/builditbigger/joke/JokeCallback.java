package com.udacity.gradle.builditbigger.joke;

public interface JokeCallback {
    void onSuccess(Joke joke);

    void onFailure();
}
