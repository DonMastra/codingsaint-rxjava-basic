package com.codingsaint.rxjava.operators.filtering;

import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class IgnoreElementsOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(IgnoreElementsOperator.class);

    private static List<Character> changeIt = new ArrayList<>();

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.primeNumbers(10))
                .ignoreElements()
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        LOGGER.info("onSubscribe");
                    }

                    @Override
                    public void onComplete() {
                        LOGGER.info("onComplete");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.info("onError");
                    }
                });
    }
}
