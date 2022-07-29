package com.codingsaint.rxjava.operators.transforming;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ScanOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScanOperator.class);

    public static void main(String[] args) {
        List<Integer> numbers = RxUtils.postiveNumbers(10);
        Observable.fromIterable(numbers)
                .scan( ((integer, integer2) -> integer + integer2) )
                .subscribe(new DemoObserver());
    }



}
