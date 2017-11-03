package com.example.domain.interactors.users;

import com.example.domain.interactors.base.Interactor;
import com.example.domain.model.users.UsersResponse;

/**
 * Created by swetashinde on 10/23/17.
 */

public interface UsersInteractor extends Interactor {

  interface Callback{
    void onGetUsersTaskComplete(UsersResponse usersResponse);
    void onGetUsersTaskError();

  }

}
