package com.itvillage.section11.class00;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Mono;

/**
 * justOrEmpty() 의 사용 예제
 *  - justOrEmpty()에 null 값을 입력하면 NullPointException 이 발생하지 않고, onNext emit 없이 onComplete 만 emit 한다.
 */
public class JustOrEmptyExample02 {
    public static void main(String[] args) {
        Mono
            .justOrEmpty(null)
            .log()
            .subscribe(Logger::onNext);
    }
}
