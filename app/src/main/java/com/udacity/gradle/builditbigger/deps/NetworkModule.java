package com.udacity.gradle.builditbigger.deps;

import android.content.Context;
import android.util.Log;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.joke.JokeService;
import com.udacity.gradle.builditbigger.joke.JokeUri;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module
public class NetworkModule {
    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String requestUrl = request.url().toString();
                        Log.d("chi6rag", "Request URL >> " + requestUrl);
                        try {
                            Response response = chain.proceed(request);
                            Log.d("chi6rag", "Response for URL << " + response.request().url().toString());
                            Log.d("chi6rag", "Response for URL: CODE: << " + response.code());
                            Log.d("chi6rag", "Body << " + response.body().toString());
                            return response;
                        } catch (Exception e) {
                            Log.d("chi6rag", e.getLocalizedMessage());
                        }
                        return null;
                    }
                })
                .build();
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

    @Singleton
    @Provides
    public JokeService jokeService(JokeUri jokeUri) {
        return new JokeService(jokeUri);
    }
}
