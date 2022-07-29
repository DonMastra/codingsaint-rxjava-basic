package com.codingsaint.rxjava.observables;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObservableUsingDefer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingDefer.class);

    public static void main(String[] args) {

        Observable<Integer> observable = Observable.defer(() -> Observable.fromIterable(RxUtils.postiveNumbers(5)));
        observable.subscribe(new DemoObserver());
        observable.subscribe(new DemoObserver());
    }
}
