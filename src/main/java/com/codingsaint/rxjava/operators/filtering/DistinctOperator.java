package com.codingsaint.rxjava.operators.filtering;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DistinctOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistinctOperator.class);

    private static List<Character> changeIt = new ArrayList<>();

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 2, 4, 1, 2, 3, 4, 5)
                .distinct()
                .subscribe(new DemoObserver());
    }
}
