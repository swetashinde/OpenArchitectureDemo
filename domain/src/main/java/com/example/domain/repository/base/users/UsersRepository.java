package com.example.domain.repository.base.users;

import com.example.domain.model.users.UsersResponse;
import io.reactivex.Observable;

/**
 * Created by swetashinde on 10/23/17.
 */

public interface UsersRepository {


  // get a list of users  ...

   UsersResponse getUsers(int numberOfUsers);
   Observable<UsersResponse> getUsersRx(int numberOfUsers);

}
