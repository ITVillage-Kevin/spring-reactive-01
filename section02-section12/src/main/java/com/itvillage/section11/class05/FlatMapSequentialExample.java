package com.itvillage.section11.class05;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * flatMap 기본 개념 예제
 *  - 평탄화 과정을 거치면서 emit 되는 순서를 보장한다.
 */
public class FlatMapSequentialExample {
    public static void main(String[] args) {
        Flux
                .range(2, 8)
                .flatMapSequential(dan -> Flux
                                    .range(1, 9)
                                    .publishOn(Schedulers.parallel())
                                    .map(n -> dan + " * " + n + " = " + dan * n))

                .subscribe(Logger::onNext);

        TimeUtils.sleep(200L);
    }
}
