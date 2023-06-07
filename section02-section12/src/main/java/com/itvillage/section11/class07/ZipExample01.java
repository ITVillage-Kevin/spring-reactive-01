package com.itvillage.section11.class07;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * zip 기본 개념 예제
 *  - 파라미터로 입력된 Publisher Sequence에서 emit된 데이터를 결합한다.
 */
public class ZipExample01 {
    public static void main(String[] args) {
        Flux
                .zip(
                        Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300L)),
                        Flux.just(4, 5, 6).delayElements(Duration.ofMillis(500L))
                )
                .subscribe(tuple2 -> Logger.onNext(tuple2));

        TimeUtils.sleep(2500L);
    }
}
