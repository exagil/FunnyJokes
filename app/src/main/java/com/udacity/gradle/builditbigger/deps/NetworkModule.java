package com.udacity.gradle.builditbigger.deps;

import android.content.Context;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.joke.JokeUri;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module
public class NetworkModule {
    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit(Context context, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public JokeUri providesJokeUri(Retrofit retrofit) {
        return retrofit.create(JokeUri.class);
    }
}
