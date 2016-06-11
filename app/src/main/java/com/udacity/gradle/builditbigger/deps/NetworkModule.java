package com.udacity.gradle.builditbigger.deps;

import android.content.Context;

import com.udacity.gradle.builditbigger.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
                .client(okHttpClient)
                .build();
    }
}
