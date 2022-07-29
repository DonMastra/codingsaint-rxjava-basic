package com.codingsaint.rxjava.operators.filtering;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TakeOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TakeOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .take(2)
                .subscribe(new DemoObserver());
    }
}
