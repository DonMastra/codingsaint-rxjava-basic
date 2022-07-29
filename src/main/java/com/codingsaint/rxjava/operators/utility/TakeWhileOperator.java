package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TakeWhileOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TakeWhileOperator.class);

    public static void main(String[] args) {
        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.postiveNumbers(10));
        positiveNumbers
                .takeWhile( integer -> integer < 4)
                .subscribe(new DemoObserver());
    }



}
