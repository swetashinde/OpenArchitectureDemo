package com.example.domain.executor.impl;

import android.support.annotation.NonNull;
import com.example.domain.executor.Executor;
import com.example.domain.interactors.base.AbstractInteractor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by swetashinde on 10/23/17.
 */

public class ThreadExecutor implements Executor {

  public static final int CORE_POOL_SIZE = 3;
  public static final int MAXIMUM_POOL_SIZE = 5;
  public static final int KEEP_ALIVE_TIME = 120;
  private static volatile ThreadExecutor threadExecutor;
  private ThreadPoolExecutor threadPoolExecutor;

  public ThreadExecutor() {
    threadPoolExecutor =
        new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
  }

  @Override public void execute(final AbstractInteractor interactor) {
    threadPoolExecutor.submit(new Runnable() {
      @Override public void run() {
        interactor.run();
        interactor.onFinished();
      }
    });
  }

  public static Executor getInstance() {
    if (threadExecutor == null) {
      threadExecutor = new ThreadExecutor();
    }
    return threadExecutor;
  }

  @Override public void execute(@NonNull Runnable command) {
    threadPoolExecutor.submit(command);
  }
}