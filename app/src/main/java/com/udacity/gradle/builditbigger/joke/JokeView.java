package com.udacity.gradle.builditbigger.joke;

public interface JokeView {
    void onJokeLoaded(Joke joke);

    void onJokeLoadFailed();
}
