package com.ddubson;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;

public class CreateObservableTest {
    @Test
    public void emitOnlyOneEvent() {
        Observable.just("Hello World!").subscribe(System.out::println);
    }

    @Test
    public void emitEventsGrabbedFromIterator() {
        Observable.fromIterable(asList("Hello", "World!"))
                .subscribe(System.out::println);
    }

    @Test
    public void emitNintegersFromStartingPoint() {
        Observable.range(0, 5).subscribe(System.out::println);
    }

    @Test
    public void emitNothing() {
        Observable.empty().subscribe(System.out::println);
    }

    @Test
    public void emitNothingEver() {
        Observable.never().subscribe(System.out::println);
    }

    @Test
    public void emitError() {
        Observable.error(new Exception("Woah! Error!")).subscribe(System.out::println, Throwable::printStackTrace);
    }

}
