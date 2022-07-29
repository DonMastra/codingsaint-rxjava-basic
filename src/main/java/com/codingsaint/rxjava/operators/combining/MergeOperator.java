package com.codingsaint.rxjava.operators.combining;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MergeOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeOperator.class);

    public static void main(String[] args) {
        Observable observable1 = Observable.fromIterable(RxUtils.shapes(5));
        Observable observable2 = Observable.fromIterable(RxUtils.postiveNumbers(5));

        Observable.merge(observable1, observable2).subscribe(new DemoObserver());
    }



}
