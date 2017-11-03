package com.example.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by swetashinde on 10/23/17.
 */

public interface MainThread {
  /**
   * Will post the results to the main thread.
   * @param runnable the runnable task.
   */
  void post(final Runnable runnable);
  Scheduler getScheduler();
}
