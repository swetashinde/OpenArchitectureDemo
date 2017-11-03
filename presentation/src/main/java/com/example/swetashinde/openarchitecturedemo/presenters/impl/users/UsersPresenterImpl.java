package com.example.swetashinde.openarchitecturedemo.presenters.impl.users;

import android.util.Log;
import com.example.domain.executor.Executor;
import com.example.domain.executor.MainThread;
import com.example.domain.interactors.impl.users.UsersInteractorImpl;
import com.example.domain.interactors.users.UsersInteractor;
import com.example.domain.model.users.UsersResponse;
import com.example.domain.repository.base.users.UsersRepository;
import com.example.swetashinde.openarchitecturedemo.presenters.AbstractPresenter;
import com.example.swetashinde.openarchitecturedemo.presenters.users.UsersPresenter;

/**
 * Created by swetashinde on 10/23/17.
 */

public class UsersPresenterImpl extends AbstractPresenter
    implements UsersPresenter,UsersInteractor.Callback {

  private static final String TAG = UsersPresenterImpl.class.getCanonicalName();
  private UsersPresenter.View view;
  private UsersRepository usersRepository;

  public UsersPresenterImpl(final Executor executor, final MainThread mainThread,final View view, final
      UsersRepository usersRepository) {
    super(executor, mainThread);
    this.view = view;
    this.usersRepository = usersRepository;

  }

  @Override public void getUsers() {

    //this will call the interactor  ...

    UsersInteractor usersInteractor = new UsersInteractorImpl(executor,mainThread,usersRepository,this);
    usersInteractor.execute();


  }

  @Override public void onError(String message) {
    Log.e(TAG, "Users screen  error");
  }

  @Override public void onGetUsersTaskComplete(UsersResponse usersResponse) {

    if(view == null){
      Log.v(TAG," view is null");

    }else{
      Log.v(TAG," view is not null .. view is not null calling task complete ");
    }

    view.onGetUsersTaskComplete(usersResponse);

  }

  @Override public void onGetUsersTaskError() {

    view.onGetUsersTasksError();
  }
}
