package com.itvillage.section08.class01;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;

/**
 * Context API 예제 코드
 *  - pullAll(ContextView) API 사용
 */
public class ContextAPIExample02 {
    public static void main(String[] args) {
        String key1 = "id";
        String key2 = "name";
        String key3 = "country";

        Mono.deferContextual(ctx ->
                        Mono.just("ID: " + " " + ctx.get(key1) + ", " + "Name: " + ctx.get(key2) +
                                ", " + "Country: " + ctx.get(key3))
        )
        .publishOn(Schedulers.parallel())
        .contextWrite(context -> context.putAll(Context.of(key2, "Kevin", key3, "Korea").readOnly()))
        .contextWrite(context -> context.put(key1, "itVillage"))
        .subscribe(Logger::onNext);

        TimeUtils.sleep(100L);
    }
}
