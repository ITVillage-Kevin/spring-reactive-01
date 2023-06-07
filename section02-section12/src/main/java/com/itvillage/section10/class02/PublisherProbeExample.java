package com.itvillage.section10.class02;

import reactor.core.publisher.Mono;

public class PublisherProbeExample {
    public static Mono<String> processWith(Mono<String> main, Mono<String> standby) {
        return main
                .flatMap(massage -> Mono.just(massage))
                .switchIfEmpty(standby);
    }

    public static Mono<String> useMainPower() {
        return Mono.empty();
    }

    public static Mono useStandbyPower() {
        return Mono.just("# use Standby Power");
    }
}
