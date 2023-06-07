package com.itvillage.section11.class03;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * skipWhile 기본 예제
 *  - 파라미터로 입력되는 Predicate가 true인 동안 emit 된 데이터를 건너뛴다.
 */
public class SkipWhileExample {
    public static void main(String[] args) {
        Flux
            .fromIterable(SampleData.btcTopPricesPerYear)
            .skipWhile(tuple -> tuple.getT2() < 10_000_000)
            .subscribe(tuple -> Logger.onNext(tuple.getT1(), tuple.getT2()));
    }
}
