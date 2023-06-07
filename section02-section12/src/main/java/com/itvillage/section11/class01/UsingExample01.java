package com.itvillage.section11.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Mono;

/**
 * using()의 개념 이해 예제
 *  - 파라미터
 *      - Callable(함수형 인터페이스): Resource를 input 으로 제공한다.(resource supplier)
 *      - Function(함수형 인터페이스): input으로 전달받은 Resouce를 새로 생성한 Publisher로 emit한다.(source supplier)
 *      - Consumer(함수형 인터페이스): 사용이 끝난 Resouce를 해제한다.(resource cleanup)
 */
public class UsingExample01 {
    public static void main(String[] args) {
        Mono
                .using(() -> "Resource",
                        resource -> Mono.just(resource),
                        resource -> Logger.info("cleanup: {}", resource)
                )
                .subscribe(Logger::onNext);
    }
}
