package com.itvillage.section07.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Schedulers.newParallel()을 적용
 */
public class SchedulersNewParallelExample01 {
    public static void main(String[] args) {
        Mono<Integer> flux =
                    Mono
                        .just(1)
                        .publishOn(Schedulers.newParallel("Parallel Thread", 4, true));


        flux.subscribe(data -> {
            TimeUtils.sleep(5000L);
            Logger.onNext("subscribe 1", data);
        });

        flux.subscribe(data -> {
            TimeUtils.sleep(4000L);
            Logger.onNext("subscribe 2", data);
        });

        flux.subscribe(data -> {
            TimeUtils.sleep(3000L);
            Logger.onNext("subscribe 3", data);
        });

        flux.subscribe(data -> {
            TimeUtils.sleep(2000L);
            Logger.onNext("subscribe 4", data);
        });

        TimeUtils.sleep(6000L);
    }
}
