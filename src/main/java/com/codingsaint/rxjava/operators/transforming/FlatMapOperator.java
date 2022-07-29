package com.codingsaint.rxjava.operators.transforming;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FlatMapOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlatMapOperator.class);

    public static void main(String[] args) {
        List<Integer> positives = RxUtils.postiveNumbers(10);

        Observable.fromIterable(positives)
                        .flatMap(integer -> twice(integer)).subscribe(new DemoObserver());
    }

    public static Observable<Integer> twice(Integer integer) {
        return Observable.create(observableEmitter -> {
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(integer * 2);
            } else {
                observableEmitter.onComplete();
            }
        });
    }

}
