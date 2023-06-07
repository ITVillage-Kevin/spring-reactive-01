package com.itvillage.section11.class05;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * flatMap 기본 개념 예제
 *  - 구구단 3단 출력 예제
 */
public class FlatMapExample02 {
    public static void main(String[] args) {
        Flux
            .just(3)
            .flatMap(dan -> Flux.range(1, 9).map(n -> dan + " * " + n + " = " + dan * n))
            .subscribe(Logger::onNext);
    }
}
