package com.codingsaint.rxjava.operators.combining;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZipOperator.class);

    public static void main(String[] args) {
        Observable shapes = Observable.fromIterable(RxUtils.shapes(5));
        Observable numbers = Observable.fromIterable(RxUtils.postiveNumbers(3));

        numbers.zipWith(shapes, (o1, o2) -> o1.toString() + ": " + o2.toString())
                .subscribe(new DemoObserver());
    }



}
