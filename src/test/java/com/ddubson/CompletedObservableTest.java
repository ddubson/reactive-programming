package com.ddubson;

import io.reactivex.Observable;
import org.junit.Test;

public class CompletedObservableTest {
    @Test
    public void erroredObservableMappingExample() {
        // Create a stream of integers
        Observable<Integer> streamOfIntegers = Observable.create(s -> {
            s.onNext(1);
            s.onNext(2);
            s.onNext(3);
            s.onNext(4);
            s.onNext(5);
            s.onComplete();
        });

        // Convert integers to pretty string and then subscribe
        // Catch error if one should happen.
        // Catch completion event
        streamOfIntegers.map(i -> "Number " + i)
                .subscribe(
                        data -> System.out.println(data),
                        error -> error.printStackTrace(),
                        () -> System.out.println("stream completed successfully.")
                );
    }
}
