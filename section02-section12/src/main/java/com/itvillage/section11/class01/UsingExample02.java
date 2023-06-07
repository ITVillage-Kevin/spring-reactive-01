package com.itvillage.section11.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * using()을 사용하기 적절한 예제
 *  - 파라미터
 *      - Callable(함수형 인터페이스): Resource를 input 으로 제공한다.(resource supplier)
 *      - Function(함수형 인터페이스): input으로 전달받은 Resouce를 새로 생성한 Publisher로 emit한다.(source supplier)
 *      - Consumer(함수형 인터페이스): 사용이 끝난 Resouce를 해제 또는 초기화 하는 등의 후처리를 한다.(resource cleanup)
 */
public class UsingExample02 {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\resources\\using_example.txt");

        Flux
            .using(() -> Files.lines(path),
                    stream -> Flux.fromStream(stream),
                    Stream::close
            )
            .subscribe(Logger::onNext);
    }
}
