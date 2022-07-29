package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TimeoutOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutOperator.class);

    public static void main(String[] args) {
        Observable.timer(2, TimeUnit.SECONDS)
                .timeout(1, TimeUnit.SECONDS)
                .subscribe(new DemoObserver());
        RxUtils.sleep(3000L);
    }



}
