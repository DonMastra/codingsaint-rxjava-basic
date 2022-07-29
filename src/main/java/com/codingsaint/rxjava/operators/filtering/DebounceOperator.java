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

public class DebounceOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebounceOperator.class);

    private static List<Character> changeIt = new ArrayList<>();

    public static void main(String[] args) {

        Random random = new Random();

        Observable.interval(2, TimeUnit.SECONDS)
                .map(character -> {
                    changeIt.add((char) (random.nextInt(26) + 'a'));
                    return changeIt;
                }).doOnEach(notification -> LOGGER.info("Current value -> {}", notification.getValue()))
                .debounce(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new DemoObserver());

        RxUtils.sleep(10000L);


    }
}
