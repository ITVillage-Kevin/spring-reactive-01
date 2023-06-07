package com.itvillage.section09.class00;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

import java.util.HashMap;
import java.util.Map;

/**
 * onOperatorDebug() Hook 메서드를 이용한 Debug mode 예제
 */
public class DebugModeExample04 {
    public static Map<String, String> fruits = new HashMap<>();

    static {
        fruits.put("banana", "바나나");
        fruits.put("apple", "사과");
        fruits.put("pear", "배");
        fruits.put("grape", "포도");
    }

    public static void main(String[] args) {
        Hooks.onOperatorDebug();

        Flux.fromArray(new String[]{"BANANAS", "APPLES", "PEARS", "MELONS"})
                .map(String::toLowerCase)
                .map(fruit -> fruit.substring(0, fruit.length() - 1))
                .map(fruits::get)
                .map(translated -> "맛있는 " + translated)
                .subscribe(Logger::onNext, Logger::onError);
    }
}
