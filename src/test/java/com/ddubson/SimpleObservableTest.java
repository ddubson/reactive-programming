package com.ddubson;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SimpleObservableTest {
    @Test
    public void simpleSynchronousObservableExample() {
        // Create a simple stream of data containing 'Hello World!' string
        Observable<String> streamOfData = Observable.create(s -> {
            s.onNext("Hello World!");
            s.onComplete();
        });

        // Create a stream consumer (observer)
        Consumer<String> observer = (data) -> System.out.println(data);

        // Subscribe the consumer to the stream (Observable)
        streamOfData.subscribe(observer);
    }

    @Test
    public void simpleSynchronousObservableConciseExample() {
        Observable.create(s -> {
            s.onNext("Hello World!");
            s.onComplete();
        }).subscribe(data -> System.out.println(data));
    }

    @Test
    public void multipleObserverSingleObservableExample() throws InterruptedException {
        // Create a simple stream of data containing 'Hello...' and '...World!' strings
        Observable<String> streamOfData = Observable.create(s -> {
            s.onNext("Hello...");
            s.onNext("...World!");
            s.onComplete();
        });

        // Create stream consumers (observers)
        Consumer<String> observer1 = (data) -> System.out.println("Observer1: " + data);
        Consumer<String> observer2 = (data) -> System.out.println("Observer2: " + data);
        Consumer<String> observer3 = (data) -> System.out.println("Observer3: " + data);

        streamOfData.subscribe(observer1);
        Thread.sleep(1000);
        streamOfData.subscribe(observer2);
        Thread.sleep(1000);
        streamOfData.subscribe(observer3);
    }
}
