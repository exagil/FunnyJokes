package com.udacity.gradle.builditbigger.joke;

import retrofit2.http.GET;

public interface JokeUri {
    @GET("jokeApi/v1/joke")
    String getRandomJoke();
}
