package com.codingsaint.rxjava.observables;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ObservableUsingRange {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingRange.class);

    public static void main(String[] args) {
        Observable.range(2, 10).subscribe(new DemoObserver());

    }
}
