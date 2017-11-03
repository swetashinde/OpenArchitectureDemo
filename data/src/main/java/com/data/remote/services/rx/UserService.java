package com.data.remote.services.rx;

import com.example.domain.model.users.UsersResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by swetashinde on 11/1/17.
 */

public interface UserService {

    @GET("api") Observable<UsersResponse> getUsers(@Query("results") int numberOfUsers);
}
