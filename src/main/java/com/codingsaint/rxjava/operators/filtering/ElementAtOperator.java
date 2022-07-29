package com.codingsaint.rxjava.operators.filtering;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ElementAtOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElementAtOperator.class);

    private static List<Character> changeIt = new ArrayList<>();

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .elementAt(15)
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        LOGGER.info("onSubscribe");
                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        LOGGER.info("onSuccess -> {}", integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.info("onError -> {}", throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LOGGER.info("onComplete");
                    }
                });
    }
}
