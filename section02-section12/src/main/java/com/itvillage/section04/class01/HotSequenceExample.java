package com.itvillage.section04.class01;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class HotSequenceExample {
    public static void main(String[] args) {
        Flux<String> concertFlux =
                Flux.fromStream(Stream.of("Singer A", "Singer B", "Singer C", "Singer D", "Singer E"))
                        .delayElements(Duration.ofSeconds(1)).share();  //  share() 원본 Flux를 여러 Subscriber가 공유한다.

        concertFlux.subscribe(singer -> Logger.info("# Subscriber1 is watching {}'s song.", singer));

        TimeUtils.sleep(2500);

        concertFlux.subscribe(singer -> Logger.info("# Subscriber2 is watching {}'s song.", singer));

        TimeUtils.sleep(3000);
    }
}
