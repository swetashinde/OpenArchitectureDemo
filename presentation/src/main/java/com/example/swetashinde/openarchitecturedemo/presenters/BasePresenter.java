package com.example.swetashinde.openarchitecturedemo.presenters;

/**
 * Created by swetashinde on 10/23/17.
 */

public interface BasePresenter {
  ///**
  // * Method that controls the lifecycle of the view. It should be called in the view's
  // * (Activity or Fragment) onPause() method.
  // */
  //void resume();
  //void pause();
  //void stop();
  //void destroy();
  //void start();
  //
  ///**
  // * Show or hide progress when a background task starts and finishes.
  // */
  //void showProgress();
  //void hideProgress();
  /**
   * Show the error message in the activity.
   * @param message
   */
  void onError(String message);
}
