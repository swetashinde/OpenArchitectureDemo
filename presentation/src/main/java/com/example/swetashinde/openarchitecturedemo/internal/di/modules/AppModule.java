package com.example.swetashinde.openarchitecturedemo.internal.di.modules;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.example.domain.executor.Executor;
import com.example.domain.executor.MainThread;
import com.example.domain.executor.impl.JavaThreadExecutor;
import com.example.domain.executor.impl.JobExecutor;
import com.example.domain.executor.impl.MainThreadImpl;
import com.example.domain.executor.impl.ThreadExecutor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 10/20/17.

 * Because we wish to setup caching, we need an Application context. Our first Dagger module, AppModule.java, will be used to provide this reference.
 */


@Module
public class AppModule {

  Application mApplication;

  public AppModule(Application mApplication) {
    this.mApplication = mApplication;
  }

  @Provides @Singleton Application providesApplication() {
    return mApplication;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.mApplication;
  }


  @Provides @Singleton MainThread provideMainThread(Handler handler) {
    return new MainThreadImpl(handler);
  }

  @Provides @Singleton Executor provideThreadExecutor() {
    return ThreadExecutor.getInstance();
  }

  @Provides @Singleton JavaThreadExecutor provideJavaThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton Handler provideHandler() {
    return new Handler(Looper.getMainLooper());
  }









}



