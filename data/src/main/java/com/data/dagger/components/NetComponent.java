package com.data.dagger.components;

import com.data.Test;
import com.data.dagger.modules.AppModule;
import com.data.dagger.modules.NetModule;
import com.data.remote.repository.impl.UsersRepositoryImpl;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 10/20/17.
 */


@Singleton
@Component(modules = { AppModule.class, NetModule.class})
public interface NetComponent {

  //void inject(MainActivity activity);
  void inject(Test test);
  void inject(UsersRepositoryImpl usersRepository);
  // void inject(MyService service);


}