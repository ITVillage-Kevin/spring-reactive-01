package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

/**
 * generate 개념 이해 예제
 *  - 파라미터
 *      - Callable(함수형 인터페이스): 초기 상태 값 또는 객체를 제공한다.(State Supplier)
 *      - BiFunction<S, T, S>(함수형 인터페이스): SynchronousSink 와 현재 상태(state)를 사용하여
 *        single signal 을 생성한다.(Generator)
 *      - Consumer(함수형 인터페이스): Generator 종료 또는 Subscriber 의 구독 취소 시, 호출 되어 후처리 작업을 한다.(State Consumer)
 */
public class GenerateExample02 {
    public static void main(String[] args) {
        Flux
                .generate(() -> Tuples.of(2, 1), (state, sink) -> {
                    sink.next(state.getT1() + " * " + state.getT2() + " = " + state.getT1() * state.getT2());
                    if (state.getT2() == 9)
                        sink.complete();
                    return Tuples.of(state.getT1(), state.getT2() + 1);
                }, state -> Logger.info("# 구구단 {}단 종료!", state.getT1()))
                .subscribe(Logger::onNext);
    }
}
