package com.itvillage.section11.class04;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * take 기본 개념 예제
 *  - 파라미터로 입력한 시간 내에 Upstream에서 emit된 데이터만 Downstream으로 emit 한다.
 */
public class TakeExample02 {
    public static void main(String[] args) {
        Flux
            .interval(Duration.ofSeconds(1))
            .doOnNext(Logger::doOnNext)
            .take(Duration.ofSeconds(2))
            .subscribe(Logger::onNext);

        TimeUtils.sleep(3000L);
    }
}
