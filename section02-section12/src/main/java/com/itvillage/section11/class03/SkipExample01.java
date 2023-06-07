package com.itvillage.section11.class03;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * skip 기본 개념 예제
 *  - 파라미터로 입력한 숫자만큼 Upstream에서 emit 되는 데이터를 건너뛴 후, 건너뛴 다음(next) 데이터부터 Downstream으로 emit 한다.
 */
public class SkipExample01 {
    public static void main(String[] args) {
        Flux
            .interval(Duration.ofSeconds(1))
            .doOnNext(Logger::doOnNext)
            .skip(3)
            .subscribe(Logger::onNext);

        TimeUtils.sleep(5000L);
    }
}
