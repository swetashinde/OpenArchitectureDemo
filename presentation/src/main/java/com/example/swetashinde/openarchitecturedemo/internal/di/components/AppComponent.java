package com.example.swetashinde.openarchitecturedemo.internal.di.components;

import com.example.swetashinde.openarchitecturedemo.application.MyApplication;
import com.example.swetashinde.openarchitecturedemo.internal.di.modules.AppModule;
import com.example.swetashinde.openarchitecturedemo.internal.di.modules.NetModule;
import com.example.swetashinde.openarchitecturedemo.ui.activities.MainActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 10/20/17.
 * The injector class used in Dagger 2 is called a component.
 * It assigns references in our activities, services, or fragments to have access to singletons we earlier defined.
 * We will need to annotate this class with a @Component annotation.
 * Note that the activities, services, or fragments that are allowed to request the dependencies declared by the modules (by means of the @Inject annotation) should be declared in this
 * class with individual inject() methods:
 */


@Singleton
@Component(modules = { AppModule.class, NetModule.class})
public interface AppComponent {

  void inject(MainActivity activity);
  void inject(AppModule appModule);
  void inject(NetModule netModule);
  void inject(MyApplication myApplication);
  // void inject(MyFragment fragment);
  // void inject(MyService service);


}
