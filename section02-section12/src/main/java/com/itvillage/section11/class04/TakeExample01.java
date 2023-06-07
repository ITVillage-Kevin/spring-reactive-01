package com.itvillage.section11.class04;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * take 기본 개념 예제
 *  - 파라미터로 입력한 숫자만큼만 Downstream으로 emit 한다.
 */
public class TakeExample01 {
    public static void main(String[] args) {
        Flux
            .interval(Duration.ofSeconds(1))
            .doOnNext(Logger::doOnNext)
            .take(3)
            .subscribe(Logger::onNext);

        TimeUtils.sleep(4000L);
    }
}
