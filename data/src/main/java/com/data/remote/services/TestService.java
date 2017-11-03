package com.data.remote.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by swetashinde on 10/20/17.
 */

public interface TestService {

  @GET("/users") Call<ResponseBody> getUsers();


}
