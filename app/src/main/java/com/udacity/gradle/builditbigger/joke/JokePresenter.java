package com.udacity.gradle.builditbigger.joke;

public class JokePresenter {
    private final JokeView jokeView;
    private final JokeService jokeService;

    public JokePresenter(JokeView jokeView, JokeService jokeService) {
        this.jokeView = jokeView;
        this.jokeService = jokeService;
    }

    public void loadRandomJoke() {
        jokeService.fetchRandomJoke(new JokeCallback() {
            @Override
            public void onSuccess(Joke joke) {
                jokeView.onJokeLoaded(joke);
            }

            @Override
            public void onFailure() {
                jokeView.onJokeLoadFailed();
            }
        });
    }
}
