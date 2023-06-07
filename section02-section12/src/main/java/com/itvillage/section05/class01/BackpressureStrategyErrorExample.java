package com.itvillage.section05.class01;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * Unbounded request 일 경우, Downstream 에 Backpressure Error 전략을 적용하는 예제
 *  - Downstream 으로 전달 할 데이터가 버퍼에 가득 찰 경우, Exception을 발생 시키는 전략
 */
public class BackpressureStrategyErrorExample {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofMillis(1L))
                .onBackpressureError()
                .doOnNext(Logger::doOnNext)
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                        TimeUtils.sleep(5L);
                        Logger.onNext(data);
                    },
                    error -> Logger.onError(error));

        TimeUtils.sleep(2000L);
    }
}
