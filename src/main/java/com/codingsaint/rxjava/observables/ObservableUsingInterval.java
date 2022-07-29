package com.codingsaint.rxjava.observables;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ObservableUsingInterval {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingInterval.class);

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS).subscribe(new DemoObserver());
        RxUtils.sleep(5000L);

    }
}
