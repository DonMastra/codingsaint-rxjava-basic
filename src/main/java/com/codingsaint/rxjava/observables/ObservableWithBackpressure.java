package com.codingsaint.rxjava.observables;

import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class ObservableWithBackpressure {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithBackpressure.class);
    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.fromIterable(RxUtils.postiveNumbers(10000))
                .repeat()
                .observeOn(Schedulers.newThread(), false, 5)
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> LOGGER.info("emitting integer ->{}", integer));

        flowable.subscribe(new Subscriber<Integer>() {

            private Subscription subscription;
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public void onSubscribe(Subscription subscription) {
                LOGGER.info("onSubscribe");
                this.subscription = subscription;
                subscription.request(5);
            }

            @Override
            public void onNext(Integer integer) {
                LOGGER.info("onNext -> {}", integer);
                RxUtils.sleep(100L);
                if (counter.incrementAndGet() % 5 == 0) {
                    subscription.request(5);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.info("OnError {}", throwable.getMessage());
            }

            @Override
            public void onComplete() {
                LOGGER.info("onComplete");
            }
        });

        RxUtils.sleep(10000L);
    }
}
