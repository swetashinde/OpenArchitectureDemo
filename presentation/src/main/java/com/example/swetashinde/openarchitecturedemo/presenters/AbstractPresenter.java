package com.example.swetashinde.openarchitecturedemo.presenters;

import com.example.domain.executor.Executor;
import com.example.domain.executor.MainThread;
import com.example.domain.executor.impl.JavaThreadExecutor;

/**
 * Created by swetashinde on 10/23/17.
 */

public abstract class AbstractPresenter {
  protected Executor executor;
  protected JavaThreadExecutor javaThreadexecutor;
  protected MainThread mainThread;

  public AbstractPresenter(final Executor executor, final MainThread mainThread) {
    this.executor = executor;
    this.mainThread = mainThread;
  }

  public AbstractPresenter(final JavaThreadExecutor executor, final MainThread mainThread) {
    this.javaThreadexecutor = executor;
    this.mainThread = mainThread;
  }
}
