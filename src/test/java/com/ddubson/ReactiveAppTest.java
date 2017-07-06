package com.ddubson;

import io.reactivex.Observable;
import org.junit.Test;

public class ReactiveAppTest {
    @Test
    public void simpleSynchronousObservable() {
        // Create a simple stream of data containing 'Hello World!' string
        Observable streamOfData = Observable.create(s -> {
            s.onNext("Hello World!");
            s.onComplete();
        });

        // Subscribe to the stream
        streamOfData.subscribe(data -> System.out.println(data));
    }
}
