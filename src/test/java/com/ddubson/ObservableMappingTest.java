package com.ddubson;

import io.reactivex.Observable;
import org.junit.Test;

public class ObservableMappingTest {
    @Test
    public void simpleObservableMappingExample() {
        // Create a stream of integers
        Observable<Integer> streamOfIntegers = Observable.create(s -> {
            s.onNext(1);
            s.onNext(2);
            s.onNext(3);
            s.onComplete();
        });

        // Convert integers to pretty string and then subscribe
        streamOfIntegers.map(i -> "Number " + i).subscribe(data -> System.out.println(data));
    }
}
