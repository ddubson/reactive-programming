package com.ddubson;

import io.reactivex.Observable;
import org.junit.Test;


public class ExceptionsObservableTest {
    @Test
    public void usingExceptionsInAnObservable() {
        Observable observable = Observable.create(subscriber -> {
            try {
                subscriber.onNext("Some Value");
                subscriber.onComplete();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });

        // Shortened, one value push, with exceptions handled
        Observable.fromCallable(() -> "Some Value");
    }
}
