package com.itvillage.section06.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import static reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST;

/**
 * Sinks.One 예제
 *  - 두 건의 데이터만 emit 하는 예제
 */
public class SinkOneExample02 {
    public static void main(String[] args) {
        // emit 된 데이터 중에서 단 하나의 데이터만 Subscriber에게 전달한다. 나머지 데이터는 Drop 됨.
        Sinks.One<String> sinkOne = Sinks.one();
        Mono<String> mono = sinkOne.asMono();

        sinkOne.emitValue("Hello Reactor", FAIL_FAST);

        // Sink.One 은 단 한개의 데이터를 emit 할 수 있기때문에 두번째 emit한 데이터는 drop 된다.
        sinkOne.emitValue("Hi Reactor", FAIL_FAST);


        mono.subscribe(data -> Logger.onNext("Subscriber1 ", data));
        mono.subscribe(data -> Logger.onNext("Subscriber2 ", data));
    }
}
