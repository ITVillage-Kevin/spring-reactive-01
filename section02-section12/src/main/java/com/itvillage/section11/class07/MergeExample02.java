package com.itvillage.section11.class07;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * merge 기본 개념 예제
 *  - 파라미터로 입력된 Publisher Sequence에서 emit된 데이터를 emit된 시간이 빠른 순서대로 merge한다.
 *  - merge operator를 정확하게 이해할 수 있는 예제
 */
public class MergeExample02 {
    public static void main(String[] args) {
        Flux
            .merge(
                    Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300L)),
                    Flux.just(4, 5, 6).delayElements(Duration.ofMillis(500L))
            )
            .subscribe(Logger::onNext);

        TimeUtils.sleep(1500L);
    }
}
