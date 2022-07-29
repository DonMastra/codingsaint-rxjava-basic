package com.codingsaint.rxjava.operators.transforming;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapOperator.class);

    public static void main(String[] args) {

        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .map(integer -> integer * 2)
                .subscribe(new DemoObserver());
    }
}
