package com.data.remote.repository.impl;

import android.app.Application;
import com.data.dagger.components.DaggerNetComponent;
import com.data.dagger.components.NetComponent;
import com.data.dagger.modules.AppModule;
import com.data.dagger.modules.NetModule;

/**
 * Created by swetashinde on 10/23/17.
 */

public class BaseRepository {

  private Application mApplication;
  private NetComponent mNetComponent;

  public BaseRepository(Application application){
    this.mApplication = application;
    mApplication = application;
    mNetComponent = getNetComponent();



  }
  public NetComponent getNetComponent(){

    NetComponent netComponent =  DaggerNetComponent.builder()
        // list of modules that are part of this component need to be created here too
        .appModule(new AppModule(mApplication)) // This also corresponds to the name of your module: %component_name%Module
        .netModule(new NetModule("https://randomuser.me/"))
        .build();

    return netComponent;
  }
}
