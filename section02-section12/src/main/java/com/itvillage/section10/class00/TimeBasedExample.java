package com.itvillage.section10.class00;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public class TimeBasedExample {
    public static Flux<Tuple2<String, Integer>> getCOVID19Count(Flux<Long> source) {
        return source
                .flatMap(notUse -> Flux.just(
                                        Tuples.of("서울", 1000),
                                        Tuples.of("경기도", 500),
                                        Tuples.of("강원도", 300),
                                        Tuples.of("충청도", 60),
                                        Tuples.of("경상도", 100),
                                        Tuples.of("전라도", 80),
                                        Tuples.of("인천", 200),
                                        Tuples.of("대전", 50),
                                        Tuples.of("대구", 60),
                                        Tuples.of("부산", 30),
                                        Tuples.of("제주도", 5)
                                    )
                );
    }

    public static Flux<Tuple2<String, Integer>> getVoteCount(Flux<Long> source) {
        return source
                .zipWith(Flux.just(
                                    Tuples.of("중구", 15400),
                                    Tuples.of("서초구", 20020),
                                    Tuples.of("강서구", 32040),
                                    Tuples.of("강동구", 14506),
                                    Tuples.of("서대문구", 35650)
                                )
                )
                .map(Tuple2::getT2);
    }
}
