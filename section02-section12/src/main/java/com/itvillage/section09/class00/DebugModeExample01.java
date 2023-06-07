package com.itvillage.section09.class00;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * Non-Debug mode
 */
public class DebugModeExample01 {
    public static void main(String[] args) {
        Flux.just(2, 4, 6, 8)
                .zipWith(Flux.just(1, 2, 3, 0), (x, y) -> x/y)
                .subscribe(Logger::onNext, Logger::onError);
    }
}
