package com.data;

import android.app.Application;
import android.content.SharedPreferences;
import com.data.dagger.components.DaggerNetComponent;
import com.data.dagger.components.NetComponent;
import com.data.dagger.modules.AppModule;
import com.data.dagger.modules.NetModule;
import javax.inject.Inject;

/**
 * Created by swetashinde on 10/20/17.
 */

public class Test {
  @Inject SharedPreferences sharedPreferences;
  Application mApplication;
  NetComponent mNetComponent;
  public Test(Application application){
    mApplication = application;
    mNetComponent = getNetComponent();

    // now inject the dependency here  ...
    getNetComponent().inject(this);  // cool it is injected :)

  }


  // you can send her context in constructor  ..

  // using context you can form the .netComponet



  public NetComponent getNetComponent(){

   NetComponent netComponent =  DaggerNetComponent.builder()
        // list of modules that are part of this component need to be created here too
        .appModule(new AppModule(mApplication)) // This also corresponds to the name of your module: %component_name%Module
        .netModule(new NetModule("https://api.github.com"))
        .build();

    return netComponent;
  }
}
