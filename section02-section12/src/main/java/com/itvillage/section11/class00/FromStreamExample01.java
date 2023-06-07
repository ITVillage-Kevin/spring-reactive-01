package com.itvillage.section11.class00;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/***
 * fromStream()의 사용 예제
 *  - Stream을 파라미터로 입력 받아 Stream에 포함된 데이터를 차례대로 emit 한다.
 */
public class FromStreamExample01 {
    public static void main(String[] args) {
        Flux
            .fromStream(SampleData.coinNames.stream())
            .subscribe(Logger::onNext);
    }
}
