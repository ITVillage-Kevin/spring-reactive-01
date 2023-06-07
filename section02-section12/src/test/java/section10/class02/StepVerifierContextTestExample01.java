package section10.class02;

import com.itvillage.section10.class01.ContextExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Reactor Sequence 에서 사용되는 Context 를 검증하는 예제
 *  - expectAccessibleContext()을 사용하여 접근 가능한 Context가 있는지를 검증한다.
 *  - hasKey()를 사용하여 Context의 key가 존재하는지 검증한다.
 *  - then()을 사용하여 검증을 위한 후속 작업을 진행할 수 있다.
 */
public class StepVerifierContextTestExample01 {
    final private static String KEY = "helloTarget";

    @Test
    public void helloMessageTest() {
        Mono<String> source = Mono.just("Hello");

        StepVerifier
                .create(ContextExample
                        .helloMessage(source, KEY)
                        .contextWrite(context -> context.put(KEY, "Reactor"))
                )
                .expectSubscription()
                .expectAccessibleContext()
                .hasKey("helloTarget")
                .then()
                .expectNext("Hello, Reactor")
                .expectComplete()
                .verify();
    }
}
