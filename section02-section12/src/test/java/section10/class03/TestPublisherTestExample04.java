package section10.class03;

import com.itvillage.section10.class00.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

/**
 * TestPublisher 를 사용해서 서비스 로직의 메서드에 대한 Unit Test 를 실시하는 예제
 *  - Reactive Streams 사양을 위반해도 Publisher가 정상 동작하게 함으로써 서비스 로직을 검증하는 예제
 */
public class TestPublisherTestExample04 {
    @Test
    public void divideByTwoTest() {
        TestPublisher<Integer> source = TestPublisher.createNoncompliant(TestPublisher.Violation.ALLOW_NULL);
//        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(GeneralExample.divideByTwo(source.flux()))
                .expectSubscription()
                .then(() -> source.next(2, 4, 6, 8, null))
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectComplete()
                .verify();
    }
}
