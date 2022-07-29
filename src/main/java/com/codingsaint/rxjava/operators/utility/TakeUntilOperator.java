package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TakeUntilOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TakeUntilOperator.class);

    public static void main(String[] args) {
        Observable singleSecond = Observable.interval(1, TimeUnit.SECONDS);
        Observable fiveSeconds = Observable.interval(5, TimeUnit.SECONDS);

        singleSecond
                .takeUntil(fiveSeconds)
                .subscribe(new DemoObserver());
        RxUtils.sleep(15000L);
    }



}
