package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DelayOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DelayOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .delay(2, TimeUnit.SECONDS)
                .subscribe(new DemoObserver());
        RxUtils.sleep(5000L);
    }



}
