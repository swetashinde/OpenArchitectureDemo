package com.example.swetashinde.openarchitecturedemo.application;

import android.app.Application;
import com.example.swetashinde.openarchitecturedemo.internal.di.components.AppComponent;
import com.example.swetashinde.openarchitecturedemo.internal.di.components.DaggerAppComponent;
import com.example.swetashinde.openarchitecturedemo.internal.di.modules.AppModule;
import com.example.swetashinde.openarchitecturedemo.internal.di.modules.NetModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by swetashinde on 10/20/17.
 */

public class MyApplication extends Application {

  private AppComponent mAppComponent;

  @Override public void onCreate() {
    super.onCreate();

    //leak canary
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return;
    }
    LeakCanary.install(this);

    // Dagger%COMPONENT_NAME%
    mAppComponent = DaggerAppComponent.builder()
        // list of modules that are part of this component need to be created here too
        .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
        .netModule(new NetModule("https://api.github.com"))
        .build();

    // If a Dagger 2 component does not have any constructor arguments for any of its modules,
    // then we can use .create() as a shortcut instead:
    //  mNetComponent = com.codepath.dagger.components.DaggerNetComponent.create();



  }

  public AppComponent getAppComponent() {
    return mAppComponent;
  }
}
