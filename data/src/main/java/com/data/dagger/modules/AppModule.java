package com.data.dagger.modules;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 10/20/17.
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


}


