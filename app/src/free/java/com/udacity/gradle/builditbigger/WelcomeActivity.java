package com.udacity.gradle.builditbigger;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.joke.Joke;
import com.udacity.gradle.builditbigger.joke.JokePresenter;
import com.udacity.gradle.builditbigger.joke.JokeService;
import com.udacity.gradle.builditbigger.joke.JokeView;

import net.chiragaggarwal.jokedisplay.JokeDisplayActivity;
import net.chiragaggarwal.jokesrepository.Jokes;

import javax.inject.Inject;

public class WelcomeActivity extends BaseActivity implements JokeView {
    @Inject
    public JokeService jokeService;
    private JokePresenter jokePresenter;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((FunnyJokesApp) getApplication()).getFunnyJokesDeps().inject(this);
        jokePresenter = new JokePresenter(this, jokeService);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.ads_unit_interstitial_welcome_joke_screen));
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
    public void onJokeLoaded(final Joke joke) {
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        if (BuildConfig.DEBUG)
            adRequestBuilder.addTestDevice(BuildConfig.DEVICE_ID);
        AdRequest adRequest = adRequestBuilder.build();
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                launchJokeActivity(joke);
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                launchJokeActivity(joke);
            }
        });
        interstitialAd.loadAd(adRequest);
    }

    @Override
    public void onJokeLoadFailed() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.joke_load_error)
                .setCancelable(true)
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    @Override
    public void showLoader() {
        super.showLoader(getString(R.string.progress_jokes));
    }

    @Override
    public void hideLoader() {
        super.hideLoader();
    }

    private void launchJokeActivity(Joke joke) {
        Intent jokeDisplayIntent = new Intent(WelcomeActivity.this, JokeDisplayActivity.class);
        jokeDisplayIntent.putExtra(Jokes.TAG, joke.description);
        startActivity(jokeDisplayIntent);
    }
}
