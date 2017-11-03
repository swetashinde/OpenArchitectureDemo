package com.example.swetashinde.openarchitecturedemo.presenters.users;

import com.example.domain.model.users.UsersResponse;
import com.example.swetashinde.openarchitecturedemo.presenters.BasePresenter;
import com.example.swetashinde.openarchitecturedemo.ui.views.BaseView;

/**
 * Created by swetashinde on 10/23/17.
 */

public interface UsersPresenter extends BasePresenter {

  interface  View extends BaseView {
    //view methods
    void onGetUsersTaskComplete(UsersResponse usersResponse);
    void onGetUsersTasksError();
  }

  //presenter method
  void getUsers();
}
