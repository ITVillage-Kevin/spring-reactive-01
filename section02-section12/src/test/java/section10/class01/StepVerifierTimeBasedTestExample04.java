package section10.class01;

import com.itvillage.section10.class00.TimeBasedExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuples;

import java.time.Duration;

/**
 * expectNoEvent(Duration)으로 지정된 대기 시간동안 이벤트가 없을을 확인하는 예제
 */
public class StepVerifierTimeBasedTestExample04 {
    @Test
    public void getCOVID19CountTest() {
        StepVerifier
                .withVirtualTime(() -> TimeBasedExample.getVoteCount(
                        Flux.interval(Duration.ofMinutes(1))
                    )
                )
                .expectSubscription()
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNext(Tuples.of("중구", 15400))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNextCount(4)
                .expectComplete()
                .verify();

    }
}
