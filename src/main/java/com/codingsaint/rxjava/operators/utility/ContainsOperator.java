package com.codingsaint.rxjava.operators.utility;

import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContainsOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainsOperator.class);

    public static void main(String[] args) {
        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.postiveNumbers(9));
                positiveNumbers.contains(10)
                .subscribe(new SingleObserver<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        LOGGER.info("Events are 10 = {}", result);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });
    }



}
