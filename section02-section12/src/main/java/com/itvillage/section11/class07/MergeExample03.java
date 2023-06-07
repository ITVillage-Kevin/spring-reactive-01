package com.itvillage.section11.class07;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * merge 활용 예제
 *  - merge를 이용하여 melt down 되고 있는 미 동부 원자력 발전소가 복구되는 메시지를 출력하는 예제
 */
public class MergeExample03 {
    public static void main(String[] args) {
        String[] usaStates = {
                "Ohio", "Michigan", "New Jersey", "Illinois", "New Hampshire",
                "Virginia", "Vermont", "North Carolina", "Ontario", "Georgia"
        };

        Flux
            .merge(getMeltDownRecoveryMessage(usaStates))
            .subscribe(Logger::onNext);

        TimeUtils.sleep(2000L);
    }

    private static List<Mono<String>> getMeltDownRecoveryMessage(String[] usaStates) {
        List<Mono<String>> messages = new ArrayList<>();
        for (String state : usaStates) {
            messages.add(SampleData.nppMap.get(state));
        }

        return messages;
    }
}
