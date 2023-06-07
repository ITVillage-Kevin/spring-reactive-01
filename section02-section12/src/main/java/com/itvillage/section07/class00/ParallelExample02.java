package com.itvillage.section07.class00;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * - parallel()만 사용할 경우에는 병렬로 작업을 수행하지 않는다.
 * - **** runOn()을 사용해서 Scheduler를 할당해주어야 병렬로 작업을 수행한다. ****
 *
 */
public class ParallelExample02 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15})
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(Logger::onNext);

        TimeUtils.sleep(100L);
    }
}
