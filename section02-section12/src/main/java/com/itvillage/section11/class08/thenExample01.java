package com.itvillage.section11.class08;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * then 기본 개념 예제
 *  - Mono의 sequence가 종료할때 까지 대기한 후, Mono<Void>를 반환한다.
 */
public class thenExample01 {
    public static void main(String[] args) {
        Mono
            .just("Hi")
            .delayElement(Duration.ofSeconds(1))
            .doOnNext(Logger::doOnNext)
            .then()
            .subscribe(
                Logger::onNext,
                Logger::onError,
                Logger::onComplete
            );

        TimeUtils.sleep(1500);
    }
}
