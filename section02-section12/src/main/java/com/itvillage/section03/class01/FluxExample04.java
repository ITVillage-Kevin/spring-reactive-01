package com.itvillage.section03.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * 여러개의 Flux를 연결해서 하나의 Flux로 결합하는 예제
 */
public class FluxExample04 {
    public static void main(String[] args) {
        Flux.concat(
                Flux.just("Venus"),
                Flux.just("Earth"),
                Flux.just("Mars"))
            .collectList()
            .subscribe(planetList -> Logger.info("# Solar System: {}", planetList));
    }
}
