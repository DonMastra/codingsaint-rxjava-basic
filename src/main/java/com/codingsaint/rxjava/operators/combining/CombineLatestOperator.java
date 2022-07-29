package com.codingsaint.rxjava.operators.combining;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CombineLatestOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CombineLatestOperator.class);

    public static void main(String[] args) {
        Observable observable1 = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Observable observable2 = Observable.interval(2000, TimeUnit.MILLISECONDS);

        Observable
                .combineLatest(observable1, observable2, (o1, o2) ->
                        "First: " + o1.toString() + ", Second: " + o2.toString())
                .take(6)
                .subscribe(new DemoObserver());

        RxUtils.sleep(10000L);
    }



}
