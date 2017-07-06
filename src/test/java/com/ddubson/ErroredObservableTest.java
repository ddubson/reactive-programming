package com.ddubson;

import io.reactivex.Observable;
import org.junit.Test;

public class ErroredObservableTest {
    @Test
    public void erroredObservableMappingExample() {
        // Create a stream of integers
        // Throw exception at end
        Observable<Integer> streamOfIntegers = Observable.create(s -> {
            s.onNext(1);
            s.onNext(2);
            s.onNext(3);
            s.onNext(4);
            s.onNext(5);
            s.onError(new Exception("Error!"));
            s.onComplete();
        });

        // Convert integers to pretty string and then subscribe
        // Catch error if one should happen.
        streamOfIntegers.map(i -> "Number " + i)
                .subscribe(
                        data -> System.out.println(data),
                        error -> error.printStackTrace()
                );
    }
}
