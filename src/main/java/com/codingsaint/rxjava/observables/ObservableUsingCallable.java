package com.codingsaint.rxjava.observables;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class ObservableUsingCallable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingCallable.class);

    public static String doSomething() {
        RxUtils.sleep(3000L);
        return "Hello World";
    }

    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return doSomething();
            }
        };
        Observable.fromCallable(callable).subscribe(new DemoObserver());
    }
}
