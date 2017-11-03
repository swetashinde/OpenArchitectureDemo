package com.example.domain.interactors.impl.users;

import com.example.domain.executor.Executor;
import com.example.domain.executor.MainThread;
import com.example.domain.interactors.base.AbstractInteractor;
import com.example.domain.interactors.users.UsersInteractor;
import com.example.domain.model.users.UsersResponse;
import com.example.domain.repository.base.users.UsersRepository;

/**
 * Created by swetashinde on 10/23/17.
 */

public class UsersInteractorImpl extends AbstractInteractor implements UsersInteractor {


  private UsersInteractor.Callback callback;
  private UsersRepository usersRepository;
  private MainThread mainThread;


  public UsersInteractorImpl(final Executor threadExecutor, final MainThread mainThread,
      final UsersRepository usersRepository, final Callback callback){

    super(threadExecutor,mainThread);
    this.mainThread = mainThread;
    this.usersRepository = usersRepository;
    this.callback = callback;

  }

  @Override public void run() {

    //code that will make the api call and return data  ....
    final UsersResponse usersResponse = usersRepository.getUsers(20);  // not aware where is get users coming from - api or db
    mainThread.post(new Runnable() {
      @Override public void run() {
        if(usersResponse != null){
          callback.onGetUsersTaskComplete(usersResponse);
        }else {
          callback.onGetUsersTaskError();
        }
      }
    });


  }
}
