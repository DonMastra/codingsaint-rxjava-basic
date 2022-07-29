package com.codingsaint.rxjava.observer;

import com.codingsaint.rxjava.observables.ObservableUsingJust;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoObserver implements Observer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingJust.class);

    @Override
    public void onSubscribe(Disposable disposable) {
        LOGGER.info("onSubscribe");
    }

    @Override
    public void onNext(Object o) {
        LOGGER.info("onNext -> {}", o);
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.info("OnError {}", throwable.getMessage());
    }

    @Override
    public void onComplete() {
        LOGGER.info("onComplete");
    }
}
