package com.itvillage.section11.class04;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * takeWhile 기본 예제
 *  - 파라미터로 입력되는 Predicate가 true인 동안 emit 된 데이터만 Downstream에 emit 한다.
 *  - emit 된 데이터에는 Predicate가 true로 matching 되는 데이터는 포함되지 않는다.
 */
public class TakeWhileExample {
    public static void main(String[] args) {
        Flux
            .fromIterable(SampleData.btcTopPricesPerYear)
            .takeWhile(tuple -> tuple.getT2() < 10_000_000)
            .subscribe(tuple -> Logger.onNext(tuple.getT1(), tuple.getT2()));
    }
}
