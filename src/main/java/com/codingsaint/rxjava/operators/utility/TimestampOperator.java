package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TimestampOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimestampOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.shapes(10))
                .timestamp()
                .subscribe(new DemoObserver());
    }



}
