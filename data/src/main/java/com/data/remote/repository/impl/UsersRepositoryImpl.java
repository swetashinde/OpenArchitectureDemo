package com.data.remote.repository.impl;

import android.app.Application;
import android.util.Log;
import com.data.remote.services.UsersService;
import com.data.remote.services.rx.UserService;
import com.example.domain.model.users.UsersResponse;
import com.example.domain.repository.base.users.UsersRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by swetashinde on 10/23/17.
 */

public class UsersRepositoryImpl extends BaseRepository implements UsersRepository  {

  @Inject Retrofit retrofit;
  @Inject @Named("rxRetrofit") Retrofit rxRetrofit;

  public UsersRepositoryImpl(Application application) {
    super(application);
    // now inject the dependency here  ...
    getNetComponent().inject(this);  // cool it is injected :)
  }

  @Override public UsersResponse getUsers(int numberOfUsers) {
    // It will talk with Service and get the data from API  ..

    UsersService usersService = retrofit.create(UsersService.class);
    UsersResponse usersResponse = null;
    try{
      Response<UsersResponse>  response =  usersService.getUsers(20).execute();  // will make sync call
      //Thread.sleep(5000); // sleep for 2 secs .. to show memory leak
      usersResponse = response.body();

      Log.d("UsersRepositoryImpl","got response from server");

    }catch (Exception ex){
      Log.d("UsersRepositoryImpl","could not connect to the server ");
    }
    return usersResponse;
  }



  //get users RX

  @Override public Observable<UsersResponse> getUsersRx(int numberOfUsers) {

    UserService userServiceRx = rxRetrofit.create(UserService.class);

    Observable<UsersResponse> observable = userServiceRx.getUsers(20);

    return  observable;



  }
}
