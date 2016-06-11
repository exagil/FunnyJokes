package com.udacity.gradle.builditbigger.deps;

import com.udacity.gradle.builditbigger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface FunnyJokesDeps {
    void inject(MainActivity mainActivity);
}
