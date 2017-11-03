package com.example.domain.executor.impl;

import android.os.Handler;
import com.example.domain.executor.MainThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by swetashinde on 10/23/17.
 */

public class MainThreadImpl implements MainThread {
  private Handler handler;

  public MainThreadImpl(Handler handler) {
    this.handler = handler;
  }
  @Override
  public void post(Runnable runnable) {
    handler.post(runnable);
  }
  @Override public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }


}
