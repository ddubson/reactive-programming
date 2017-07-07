package com.ddubson;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimerAndIntervalObservableTest {
    @Test
    public void usingATimerToSpaceOutObservablePushes() {
        Observable.timer(1, TimeUnit.SECONDS).subscribe(System.out::println);
    }

    @Test
    public void usingAnInterval() {
        Observable.interval(1_000_000 / 60, TimeUnit.MICROSECONDS).subscribe(System.out::println);
    }
}
