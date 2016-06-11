package com.udacity.gradle.builditbigger;

import android.app.Application;

import com.udacity.gradle.builditbigger.deps.AppModule;
import com.udacity.gradle.builditbigger.deps.DaggerFunnyJokesDeps;
import com.udacity.gradle.builditbigger.deps.FunnyJokesDeps;

public class FunnyJokesApp extends Application {
    private FunnyJokesDeps funnyJokesDeps;

    @Override
    public void onCreate() {
        super.onCreate();
        funnyJokesDeps = DaggerFunnyJokesDeps
                .builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public FunnyJokesDeps getFunnyJokesDeps() {
        return this.funnyJokesDeps;
    }
}
