package com.example.domain.model.users;

import org.parceler.Parcel;

/**
 * Created by swetashinde on 10/23/17.
 */

@Parcel
public class Picture {

  String large;
  String medium;
  String thumbnail;

  public Picture() {
  }

  public String getLarge() {
    return large;
  }

  public void setLarge(String large) {
    this.large = large;
  }

  public String getMedium() {
    return medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
}