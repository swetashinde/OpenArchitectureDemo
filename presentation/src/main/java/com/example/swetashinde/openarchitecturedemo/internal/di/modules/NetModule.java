package com.example.swetashinde.openarchitecturedemo.internal.di.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by swetashinde on 10/20/17.
 *
 * We create a class called NetModule.java and annotate it with @Module to signal to Dagger to search within the available methods for possible instance providers.

 The methods that will actually expose available return types should also be annotated with the @Provides annotation.
 The @Singleton annotation also signals to the Dagger compiler that the instance should be created only once in the application.
 In the following example, we are specifying SharedPreferences, Gson, Cache, OkHttpClient, and Retrofit as the return types that can be used as part of the dependency list.
 */

@Module
public class NetModule {
  String mBaseUrl;

  public NetModule(String mBaseUrl) {
    this.mBaseUrl = mBaseUrl;
  }


  // Dagger will only look for methods annotated with @Provides
  @Provides
  @Singleton
  // Application reference must come from AppModule.class
  SharedPreferences providesSharedPreferences(Application application) {
    return PreferenceManager.getDefaultSharedPreferences(application);
  }

  @Provides
  @Singleton
  Cache provideOkHttpCache(Application application) {
    int cacheSize = 10 * 1024 * 1024; // 10 MiB
    Cache cache = new Cache(application.getCacheDir(), cacheSize);
    return cache;
  }

  @Provides
  @Singleton Gson provideGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return gsonBuilder.create();
  }

  @Provides
  @Singleton OkHttpClient provideOkHttpClient(Cache cache) {

    OkHttpClient client = new OkHttpClient.Builder()
        //.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
        .cache(cache)
        .build();
    return client;
  }

  @Provides
  @Singleton Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
    Retrofit retrofit = new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(mBaseUrl)
        .client(okHttpClient)
        .build();
    return retrofit;
  }





}
