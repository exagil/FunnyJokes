package com.udacity.gradle.builditbigger.joke;

public class JokePresenter {
    private final JokeView jokeView;
    private final JokeService jokeService;

    public JokePresenter(JokeView jokeView, JokeService jokeService) {
        this.jokeView = jokeView;
        this.jokeService = jokeService;
    }

    public void loadRandomJoke() {
        jokeView.showLoader();
        jokeService.fetchRandomJoke(new JokeCallback() {
            @Override
            public void onSuccess(Joke joke) {
                jokeView.hideLoader();
                jokeView.onJokeLoaded(joke);
            }

            @Override
            public void onFailure() {
                jokeView.hideLoader();
                jokeView.onJokeLoadFailed();
            }
        });
    }
}
