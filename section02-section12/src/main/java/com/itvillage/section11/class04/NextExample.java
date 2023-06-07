package com.itvillage.section11.class04;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * next 기본 예제
 *  - emit 된 데이터 중에서 첫번째 데이터만 Downstream 으로 emit 한다.
 */
public class NextExample {
    public static void main(String[] args) {
        Flux
            .fromIterable(SampleData.btcTopPricesPerYear)
            .next()
            .subscribe(tuple -> Logger.onNext(tuple.getT1(), tuple.getT2()));
    }
}
