package com.example.domain.executor.impl;

import io.reactivex.Scheduler;

/**
 * Created by swetashinde on 10/23/17.
 */
public interface PostExecutionThread {
  Scheduler getScheduler();
}
