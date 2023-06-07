package com.itvillage.section11.class00;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/***
 * fromIterable()의 사용 예제
 *  - Iterable의 구현 클래스를 파라미터로 입력 받아 차례대로 emit한다.
 */
public class FromIterableExample02 {
    public static void main(String[] args) {
        Flux
            .fromIterable(SampleData.coins)
            .subscribe(coin -> Logger.onNext("coin 명: " + coin.getT1() + ", 현재가: " + coin.getT2()));
    }
}
