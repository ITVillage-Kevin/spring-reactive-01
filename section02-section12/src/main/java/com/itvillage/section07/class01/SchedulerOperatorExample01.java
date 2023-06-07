package com.itvillage.section07.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * Sequence의 Operator 체인에서 최초의 쓰레드는 subscribe()가
 * 호출되는 scope에 있는 쓰레드이다.
 */
public class SchedulerOperatorExample01 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .filter(data -> data > 3)
                .map(data -> data * 10)
                .subscribe(Logger::onNext);
    }
}
