package com.example.domain.interactors.base;

import com.example.domain.executor.Executor;
import com.example.domain.executor.MainThread;

/**
 * Created by swetashinde on 10/23/17.
 */

public abstract class AbstractInteractor implements Interactor {

  public static final String SUCCESS = "SUCCESS";
  public static final String FAILURE = "FAILURE";

  private boolean isRunning;
  private Executor threadExecutor;
  private MainThread mainThread;
  protected volatile boolean mIsCanceled;
  protected volatile boolean mIsRunning;
  public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
    this.threadExecutor = threadExecutor;
    this.mainThread = mainThread;
  }

  public abstract void run();
  public void onFinished() {
    mIsRunning = false;
    mIsCanceled = false;
  }
  public void execute() {
    this.isRunning = true;
    threadExecutor.execute(this);
  }

}
