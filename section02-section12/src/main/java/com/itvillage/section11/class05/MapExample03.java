package com.itvillage.section11.class05;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * map 활용 예제
 *  - Morse Code를 알파벳으로 변환하는 예제
 */
public class MapExample03 {
    public static void main(String[] args) {
        Flux
            .just("...", "---", "...")
            .map(code -> transformMorseCode(code))
            .subscribe(Logger::onNext);
    }

    public static String transformMorseCode(String morseCode) {
        return SampleData.morseCodeMap.get(morseCode);
    }
}
