package com.example.domain.model.users;

import org.parceler.Parcel;

/**
 * Created by swetashinde on 10/23/17.
 */

@Parcel
public class Name {

  String title;
  String first;
  String last;

  public Name(){

  }

  public Name(String title,String first,String last){
    this.title = title;
    this.first = first;
    this.last = last;
  }

  @Override
  public String toString(){

    return capitalize(this.title)+ " "+capitalize(this.first)+" "+capitalize(this.last); //

  }

  private String capitalize(final String line) {
    return Character.toUpperCase(line.charAt(0)) + line.substring(1);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }
}