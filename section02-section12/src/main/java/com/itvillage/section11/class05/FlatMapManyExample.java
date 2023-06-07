package com.itvillage.section11.class05;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/**
 * flatMapMany 활용 예제
 *  - Mono 에서 emit 된 데이터를 Flux 로 변환한다.
 *  - 특정 가격에 BTC를 구매했을 때 연도별 최고가일 경우 수익 금액 계산하기.
 *      수익 금액 = (현재 가격 * 투자 금액 / 구매시 가격 ) - 원금
 */
public class FlatMapManyExample {
    public static void main(String[] args) {
        Mono
                .just(Tuples.of(500, 1000))
                .flatMapMany(buyInfo -> calculateMaxProfitPerYear(buyInfo))

                .subscribe(Logger::onNext);

        TimeUtils.sleep(200L);
    }

    private static Flux<Long> calculateMaxProfitPerYear(Tuple2<Integer, Integer> buyInfo) {
        return Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .map(btcInfo -> btcInfo.getT2() * buyInfo.getT2() / buyInfo.getT1() - buyInfo.getT2());
    }
}
