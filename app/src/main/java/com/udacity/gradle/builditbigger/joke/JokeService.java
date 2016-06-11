package com.udacity.gradle.builditbigger.joke;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class JokeService {
    private final JokeUri jokeUri;

    public JokeService(JokeUri jokeUri) {
        this.jokeUri = jokeUri;
    }

    public void fetchRandomJoke(final JokeCallback jokeCallback) {
        this.jokeUri.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Joke>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        jokeCallback.onFailure();
                    }

                    @Override
                    public void onNext(Joke joke) {
                        jokeCallback.onSuccess(joke);
                    }
                });
    }
}
