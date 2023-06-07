package com.itvillage.section11.class07;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

/**
 * zip 활용 예제
 *  - 수도권의 시간별 코로나 확진자 수를 집계하는 예제
 */
public class ZipExample03 {
    public static void main(String[] args) {
        getInfectedPersonsPerHour(10, 21)
                .subscribe(tuples -> {
                    Tuple3<Tuple2, Tuple2, Tuple2> t3 = (Tuple3) tuples;
                    int sum = (int) t3.getT1().getT2() + (int) t3.getT2().getT2() + (int) t3.getT3().getT2();
                    Logger.onNext(t3.getT1().getT1(), sum);
                });
        TimeUtils.sleep(6000L);
    }

    private static Flux getInfectedPersonsPerHour(int start, int end) {
        return Flux.zip(
                Flux.fromIterable(SampleData.seoulInfected)
                        .filter(t2 -> t2.getT1() >= start && t2.getT1() <= end),
                Flux.fromIterable(SampleData.incheonInfected)
                        .filter(t2 -> t2.getT1() >= start && t2.getT1() <= end),
                Flux.fromIterable(SampleData.suwonInfected)
                        .filter(t2 -> t2.getT1() >= start && t2.getT1() <= end)
        );
    }
}
