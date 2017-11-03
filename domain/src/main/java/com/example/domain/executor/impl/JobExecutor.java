package com.example.domain.executor.impl;

import android.support.annotation.NonNull;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 10/23/17.
 */

@Singleton public class JobExecutor implements JavaThreadExecutor {
  private final ThreadPoolExecutor threadPoolExecutor;

  @Inject JobExecutor() {
    this.threadPoolExecutor =
        new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
            new JobThreadFactory());
  }

  @Override public void execute(@NonNull Runnable runnable) {
    this.threadPoolExecutor.execute(runnable);
  }

  private static class JobThreadFactory implements ThreadFactory {
    private int counter = 0;

    @Override public Thread newThread(@NonNull Runnable runnable) {
      return new Thread(runnable, "android_" + counter++);
    }
  }
}
