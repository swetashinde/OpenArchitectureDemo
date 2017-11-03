package com.example.domain.interactors.base;

import com.example.domain.executor.MainThread;
import com.example.domain.executor.impl.JavaThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by swetashinde on 10/23/17.
 */

public abstract class UseCase<T, Params> {

  private final JavaThreadExecutor threadExecutor;
  private final MainThread postExecutionThread;
  private final CompositeDisposable disposables;

  public UseCase(JavaThreadExecutor executor, MainThread mainThread) {
    this.threadExecutor = executor;
    this.postExecutionThread = mainThread;
    this.disposables = new CompositeDisposable();
  }

  /**
   * Builds an {@link Observable} which will be used when executing the current {@link
   * UseCase}.
   */
  public abstract Observable<T> buildUseCaseObservable(Params params);

  /**
   * Executes the current use case.
   *
   * @param observer {@link DisposableObserver} which will be listening to the observable
   * build
   * by {@link #buildUseCaseObservable(Params)} ()} method.
   * @param params Parameters (Optional) used to build/execute this use case.
   */
  public void execute(DisposableObserver<T> observer, Params params) {
    final Observable<T> observable = this.buildUseCaseObservable(params)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler());
    addDisposable(observable.subscribeWith(observer));
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  public void dispose() {
    if (!disposables.isDisposed()) {
      disposables.dispose();
    }
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  private void addDisposable(Disposable disposable) {
    if (null != disposable) {
      disposables.add(disposable);
    }
  }
}