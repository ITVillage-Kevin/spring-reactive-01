package com.itvillage.section03.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * Flux 기본 예제
 */
public class FluxExample01 {
    public static void main(String[] args) {
        Flux.just(6, 9, 13)
                .map(num -> num % 2)
                .subscribe(remainder -> Logger.info("# remainder: {}", remainder));
    }
}
