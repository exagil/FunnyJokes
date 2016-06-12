package com.udacity.gradle.builditbigger.joke;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import utilities.Fixture;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JokePresenterTest {
    @Test
    public void testThatJokePresenterKnowsHowToLoadTheJoke() {
        final Joke actualJoke = new Fixture<Joke>(Joke.class, "valid_joke_response.json").load();
        final Joke expectedJoke = new Joke("My wife and I were happy for twenty years. Then we met.");
        JokeService jokeService = mock(JokeService.class);
        JokeView jokeView = mock(JokeView.class);
        JokePresenter jokePresenter = new JokePresenter(jokeView, jokeService);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                JokeCallback jokeCallback = (JokeCallback) invocation.getArguments()[0];
                jokeCallback.onSuccess(actualJoke);
                return null;
            }
        }).when(jokeService).fetchRandomJoke(Matchers.<JokeCallback>any());
        jokePresenter.loadRandomJoke();
        verify(jokeView).showLoader();
        verify(jokeView).onJokeLoaded(expectedJoke);
        verify(jokeView).hideLoader();
    }

    @Test
    public void testThatJokePresenterKnowsWhenItCouldNotFetchJokes() {
        JokeService jokeService = mock(JokeService.class);
        JokeView jokeView = mock(JokeView.class);
        JokePresenter jokePresenter = new JokePresenter(jokeView, jokeService);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                JokeCallback jokeCallback = (JokeCallback) invocation.getArguments()[0];
                jokeCallback.onFailure();
                return null;
            }
        }).when(jokeService).fetchRandomJoke(Matchers.<JokeCallback>any());
        jokePresenter.loadRandomJoke();
        verify(jokeView).showLoader();
        verify(jokeView).onJokeLoadFailed();
        verify(jokeView).hideLoader();
    }
}
