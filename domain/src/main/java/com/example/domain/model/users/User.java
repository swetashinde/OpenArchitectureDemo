package com.example.domain.model.users;

import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

/**
 * Created by swetashinde on 10/23/17.
 */

@Parcel
public class User {

  Name name;
  Picture picture;
  String gender;
  String email;
  @SerializedName("phone")
  String phoneNumber;

  public User() {
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Picture getPicture() {
    return picture;
  }

  public void setPicture(Picture picture) {
    this.picture = picture;
  }
}