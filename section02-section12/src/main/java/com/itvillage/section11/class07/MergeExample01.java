package com.itvillage.section11.class07;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * merge 기본 개념 예제
 *  - 파라미터로 입력된 Publisher Sequence에서 emit된 데이터를 merge한다.
 *  - merge operator를 정확하게 이해하기 어려운 예제
 */
public class MergeExample01 {
    public static void main(String[] args) {
        Flux
            .merge(Flux.just(1, 2, 3), Flux.just(4, 5, 6))
            .subscribe(Logger::onNext);
    }
}
