package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AllOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllOperator.class);

    public static void main(String[] args) {
        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.postiveNumbers(10));
                positiveNumbers.all(integer -> integer > 5)
                .subscribe(new SingleObserver<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        LOGGER.info("Events are > 5 = {}", result);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });
    }



}
