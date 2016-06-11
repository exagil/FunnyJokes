package com.udacity.gradle.builditbigger.joke;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import utilities.Fixture;
import utilities.RxSchedulersOverrideRule;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JokeServiceTest {
    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();
    private JokeCallback jokeCallback;
    private JokeUri jokeUri;
    private JokeService jokeService;

    @Before
    public void setup() {
        jokeCallback = Mockito.mock(JokeCallback.class);
        jokeUri = mock(JokeUri.class);
        jokeService = new JokeService(jokeUri);
    }

    @Test
    public void testThatJokeServiceShouldFetchTheJoke() {
        Joke actualJoke = new Fixture<Joke>(Joke.class, "valid_joke_response.json").load();
        final Joke expectedJoke = new Joke("My wife and I were happy for twenty years. Then we met.");
        JokeService jokeService = new JokeService(jokeUri);
        when(jokeUri.getRandomJoke()).thenReturn(Observable.just(actualJoke));
        jokeService.fetchRandomJoke(jokeCallback);
        verify(jokeCallback).onSuccess(expectedJoke);
    }

    @Test
    public void testThatJokeServiceShouldKnowIfItWasNotAbleToFetchTheJoke() {
        ResponseBody responseBody = ResponseBody.create(MediaType.parse(""), "");
        Response<String> response = Response.error(503, responseBody);
        HttpException httpException = new HttpException(response);
        doReturn(Observable.error(httpException)).when(jokeUri).getRandomJoke();
        jokeService.fetchRandomJoke(jokeCallback);
        verify(jokeCallback).onFailure();
    }
}
