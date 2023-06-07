package com.itvillage.section11.class08;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

public class CollectListExample01 {
    public static void main(String[] args) {
        Flux
            .just("...", "---", "...")
            .map(code -> transformMorseCode(code))
            .collectList()
            .subscribe(list -> Logger.onNext(list.stream().collect(Collectors.joining())));
    }

    public static String transformMorseCode(String morseCode) {
        return SampleData.morseCodeMap.get(morseCode);
    }
}
