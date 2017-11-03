package com.data.remote.services;

import com.example.domain.model.users.UsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by swetashinde on 10/23/17.
 */

public interface UsersService {
  @GET("api")
  Call<UsersResponse> getUsers(@Query("results") int numberOfUsers);
}
