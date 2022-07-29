package com.codingsaint.rxjava.operators.filtering;

import com.codingsaint.rxjava.models.Shape;
import com.codingsaint.rxjava.observer.DemoObserver;
import com.codingsaint.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FilterOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterOperator.class);

    public static void main(String[] args) {
        List<Shape> shapes = RxUtils.shapes(10);
        for (Shape s : shapes) {
            LOGGER.info("shape -> {}", s);
        }
        Observable.fromIterable(shapes)
                .filter( shape -> shape.getColor().equals("blue"))
                .subscribe(new DemoObserver());
    }
}
