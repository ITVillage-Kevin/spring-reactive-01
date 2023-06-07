package com.itvillage.section02.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

public class HelloReactorExample {
    public static void main(String[] args) {
        Flux<String> sequence = Flux.just("Hello", "Reactor");
        sequence
                .map(data -> data.toLowerCase())
                .subscribe(data -> Logger.onNext(data));
    }
}
