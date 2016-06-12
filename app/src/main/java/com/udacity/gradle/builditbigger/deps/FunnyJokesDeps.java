package com.udacity.gradle.builditbigger.deps;

import com.udacity.gradle.builditbigger.WelcomeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface FunnyJokesDeps {
    void inject(WelcomeActivity welcomeActivity);
}
