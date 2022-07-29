package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DoOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.shapes(10))
                .doOnSubscribe(disposable -> LOGGER.info("Stream is subscribed"))
                .doOnEach(shapeNotification -> LOGGER.info("Current value {}", shapeNotification.getValue()))
                .doOnNext(shape -> LOGGER.info("Shape is {}", shape))
                .doOnComplete(() -> LOGGER.info("Completed"))
                .subscribe(new DemoObserver());

        RxUtils.sleep(5000L);

    }



}
