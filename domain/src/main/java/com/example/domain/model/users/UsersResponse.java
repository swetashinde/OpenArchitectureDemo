package com.example.domain.model.users;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.parceler.Parcel;

/**
 * Created by swetashinde on 10/23/17.
 */
@Parcel
public class UsersResponse {
  @SerializedName("results") List<User> users;

  public UsersResponse() {
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
