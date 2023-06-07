package com.itvillage.section07.class01;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Operator 체인에서 publishOn( )이 호출되면 publishOn( ) 호출 이후의 Operator 체인은
 * *** 다음 publisherOn( )을 만나기전까지 *** publishOn( )에서 지정한 Thread에서 실행이 된다.
 */
public class SchedulerOperatorExample03 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .doOnNext(data -> Logger.doOnNext("fromArray", data))
                .publishOn(Schedulers.parallel())
                .filter(data -> data > 3)
                .doOnNext(data -> Logger.doOnNext("filter", data))
                .publishOn(Schedulers.parallel())
                .map(data -> data * 10)
                .doOnNext(data -> Logger.doOnNext("map", data))
                .subscribe(Logger::onNext);

        TimeUtils.sleep(500L);
    }
}
