package com.udacity.gradle.builditbigger.joke;

import retrofit2.http.GET;
import rx.Observable;

public interface JokeUri {
    @GET("jokeApi/v1/joke")
    Observable<Joke> getRandomJoke();
}
