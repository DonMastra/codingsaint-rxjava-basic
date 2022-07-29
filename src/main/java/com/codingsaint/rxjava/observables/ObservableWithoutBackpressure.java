package com.codingsaint.rxjava.observables;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObservableWithoutBackpressure {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithoutBackpressure.class);
    public static void main(String[] args) {
        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.postiveNumbers(10000))
                .repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread());

        positiveNumbers.subscribe(new DemoObserver());
        RxUtils.sleep(1000L);
    }
}
