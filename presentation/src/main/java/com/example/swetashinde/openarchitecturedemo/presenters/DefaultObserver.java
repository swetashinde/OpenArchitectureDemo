package com.example.swetashinde.openarchitecturedemo.presenters;

/**
 * Created by swetashinde on 10/23/17.
 */

import io.reactivex.observers.DisposableObserver;

/**
 * Default {@link DisposableObserver} base class to be used whenever you want default error
 * handling.
 */
public class DefaultObserver<T> extends DisposableObserver<T> {
  @Override public void onNext(T t) {
    // no-op by default.
  }

  @Override public void onComplete() {
    // no-op by default.
  }

  @Override public void onError(Throwable exception) {
    // no-op by default.
  }
}