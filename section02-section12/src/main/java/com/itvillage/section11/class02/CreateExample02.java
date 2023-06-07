package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * create 개념 이해 예제
 *  - Subscriber의 request와 상관없이 next signal 이벤트를 발생하는 예제
 */
public class CreateExample02 {
    public static void main(String[] args) {
        Logger.info("# start");

        CryptoCurrencyPriceEmitter priceEmitter = new CryptoCurrencyPriceEmitter();

        Flux.create((FluxSink<Integer> sink) -> {
            priceEmitter.setListener(new CryptoCurrencyPriceListener() {
                @Override
                public void onPrice(List<Integer> priceList) {
                    priceList.stream().forEach(price -> {
                        sink.next(price);
                    });
                }

                @Override
                public void onComplete() {
                    sink.complete();
                }
            });
        })
        .publishOn(Schedulers.parallel())
        .subscribe(
            data -> Logger.onNext(data),
            error -> {},
            () -> Logger.info("# onComplete"));

        TimeUtils.sleep(3000L);

        priceEmitter.flowInto();

        TimeUtils.sleep(2000L);
        priceEmitter.complete();

        TimeUtils.sleep(100L);
    }
}
