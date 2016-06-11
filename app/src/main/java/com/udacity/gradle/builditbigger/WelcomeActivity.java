package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.joke.Joke;
import com.udacity.gradle.builditbigger.joke.JokePresenter;
import com.udacity.gradle.builditbigger.joke.JokeService;
import com.udacity.gradle.builditbigger.joke.JokeView;

import net.chiragaggarwal.jokedisplay.JokeDisplayActivity;
import net.chiragaggarwal.jokesrepository.Jokes;

import javax.inject.Inject;

public class WelcomeActivity extends ActionBarActivity implements JokeView {
    @Inject
    public JokeService jokeService;
    private JokePresenter jokePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((FunnyJokesApp) getApplication()).getFunnyJokesDeps().inject(this);
        jokePresenter = new JokePresenter(this, jokeService);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadJoke(View view) {
        jokePresenter.loadRandomJoke();
    }

    @Override
    public void onJokeLoaded(Joke joke) {
        Intent jokeDisplayIntent = new Intent(this, JokeDisplayActivity.class);
        jokeDisplayIntent.putExtra(Jokes.TAG, joke);
        startActivity(jokeDisplayIntent);
    }

    @Override
    public void onJokeLoadFailed() {

    }
}
