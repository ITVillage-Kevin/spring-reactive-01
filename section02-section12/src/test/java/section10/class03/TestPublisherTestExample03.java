package section10.class03;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

/**
 * TestPublisher 를 사용해서 서비스 로직의 메서드에 대한 Unit Test 를 실시하는 예제
 *  - 정상 동작하는 TestPublisher
 *  - emit() 사용
 */
public class TestPublisherTestExample03 {
    @Test
    public void divideByTwoTest() {
        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(source.flux())
                .expectSubscription()
                .then(() -> source.emit(1, 2, 3))
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectComplete()
                .verify();
    }
}
