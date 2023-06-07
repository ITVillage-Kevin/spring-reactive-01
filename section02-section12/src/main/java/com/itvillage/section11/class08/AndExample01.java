package com.itvillage.section11.class08;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * and 기본 개념 예제
 *  - Mono와 파라미터로 입력된 Publisher가 종료할때 까지 대기한 후, Mono<Void>를 반환한다.
 */
public class AndExample01 {
    public static void main(String[] args) {
        Mono
            .just("Okay")
            .delayElement(Duration.ofSeconds(1))
            .doOnNext(Logger::doOnNext)
            .and(
                Flux
                    .just("Hi", "Tom")
                    .delayElements(Duration.ofSeconds(2))
                    .doOnNext(Logger::doOnNext)
            )
            .subscribe(
                Logger::onNext,
                Logger::onError,
                Logger::onComplete
            );

        TimeUtils.sleep(5000);
    }
}
