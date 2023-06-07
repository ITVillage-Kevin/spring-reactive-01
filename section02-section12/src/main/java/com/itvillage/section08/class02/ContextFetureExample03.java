package com.itvillage.section08.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Context의 특징
 *  - 동일한 키에 대해서 write 할 경우, 해당 키에 대한 값을 덮어 쓴다.
 */
public class ContextFetureExample03 {
    public static void main(String[] args) {
        String key1 = "id";

        Mono.deferContextual(ctx ->
                Mono.just("ID: " + " " + ctx.get(key1))
        )
        .publishOn(Schedulers.parallel())
        .contextWrite(context -> context.put(key1, "itWorld"))
        .contextWrite(context -> context.put(key1, "itVillage"))
        .subscribe(Logger::onNext);

        TimeUtils.sleep(100L);
    }
}
