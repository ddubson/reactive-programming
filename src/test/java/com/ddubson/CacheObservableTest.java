package com.ddubson;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import org.junit.Test;

public class CacheObservableTest {
    @Test
    public void cacheObservableEventsForMultipleObservers() {
        Observable observable = Observable.create(s -> {
            System.out.println("Created (only called once");
            s.onNext("Hello");
            s.onComplete();
        }).cache();

        Consumer<String> consumer1 = s -> System.out.println("Consumer1: " + s);
        Consumer<String> consumer2 = s -> System.out.println("Consumer2: " + s);
        Consumer<String> consumer3 = s -> System.out.println("Consumer3: " + s);

        observable.subscribe(consumer1);
        observable.subscribe(consumer2);
        observable.subscribe(consumer3);
    }
}
