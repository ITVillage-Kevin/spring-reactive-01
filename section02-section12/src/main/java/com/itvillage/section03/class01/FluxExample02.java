package com.itvillage.section03.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * Flux 에서의 Operator 체인 사용 예제
 */
public class FluxExample02 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{3, 6, 7, 9})
                .filter(num -> num > 6)
                .map(num -> num * 2)
                .subscribe(multiply -> Logger.info("# multiply: {}", multiply));
    }
}
