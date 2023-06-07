package com.itvillage.section11.class00;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * range()의 사용 예제
 *  - 명령형 방식의 for 문을 대체하는 예제
 */
public class RangeExample02 {
    public static void main(String[] args) {
        List<String> coinNames = SampleData.coinNames;

        Flux
            .range(0, coinNames.size())
            .subscribe(index -> Logger.onNext(coinNames.get(index)));
    }
}
