package com.itvillage.section11.class05;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * map 활용 예제
 *  - 2021년도의 비트코인 최고가 시점의 수익률을 계산하는 예제
 */
public class MapExample02 {
    public static void main(String[] args) {
        final double buyPrice = 40_000_000;
        Flux
            .fromIterable(SampleData.btcTopPricesPerYear)
            .filter(tuple -> tuple.getT1() == 2021)
            .doOnNext(Logger::doOnNext)
            .map(tuple -> calculateProfitRate(buyPrice, tuple.getT2()))
            .subscribe(result -> Logger.onNext(result + "%"));
    }

    private static double calculateProfitRate(final double buyPrice, Long topPrice) {
        return (topPrice - buyPrice) / buyPrice * 100;
    }
}
