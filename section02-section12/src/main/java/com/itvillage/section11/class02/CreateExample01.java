package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Arrays;
import java.util.List;

/**
 * create 개념 이해 예제
 *  - Subscriber 가 request 할 경우에 next signal 이벤트를 발생하는 예제
 *  - generate operator 와 달리 한번에 여러 건의 next signal 이벤트를 발생 시킬 수 있다.
 */
public class CreateExample01 {
    public static int SIZE = 0;
    public static int COUNT = -1;
    private static List<Integer> dataSource =
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    public static void main(String[] args) {
        Logger.info("# start");
        Flux.create((FluxSink<Integer> emitter) -> {
            emitter.onRequest(n -> {
                TimeUtils.sleep(1000L);
                for (int i = 0; i < n; i++) {
                    if (COUNT >= 9) {
                        emitter.complete();
                    } else {
                        COUNT++;
                        emitter.next(dataSource.get(COUNT));
                    }
                }
            });

            emitter.onDispose(() -> Logger.info("# clean up"));
        }).subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(2);
            }

            @Override
            protected void hookOnNext(Integer value) {
                SIZE++;
                Logger.onNext(value);
                if (SIZE == 2) {
                    request(2);
                    SIZE = 0;
                }
            }

            @Override
            protected void hookOnComplete() {
                Logger.onComplete("# onComplete");
            }
        });
    }
}
