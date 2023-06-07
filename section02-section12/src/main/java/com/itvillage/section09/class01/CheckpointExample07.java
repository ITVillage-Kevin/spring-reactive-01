package com.itvillage.section09.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * 분리된 method 에서 checkpoint() Operator 를 이용한 예제
 */
public class CheckpointExample07 {
    public static void main(String[] args) {
        Flux<Integer> source = Flux.just(2, 4, 6, 8);
        Flux<Integer> other = Flux.just(1, 2, 3, 0);

        Flux<Integer> multiplySource = divide(source, other).checkpoint();
        Flux<Integer> plusSource = plus(multiplySource).checkpoint();


        plusSource.subscribe(Logger::onNext, Logger::onError);
    }

    private static Flux<Integer> divide(Flux<Integer> source, Flux<Integer> other) {
        return source.zipWith(other, (x, y) -> x/y);
    }

    private static Flux<Integer> plus(Flux<Integer> source) {
        return source.map(num -> num + 2);
    }
}
