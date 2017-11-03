package com.example.domain.executor;

import com.example.domain.interactors.base.AbstractInteractor;

/**
 * Created by swetashinde on 10/23/17.
 */

public interface Executor extends java.util.concurrent.Executor {
  /**
   * This method will call the interactor's run method.
   *
   * @param interactor interactor to run.
   */
  void execute(final AbstractInteractor interactor);
}
