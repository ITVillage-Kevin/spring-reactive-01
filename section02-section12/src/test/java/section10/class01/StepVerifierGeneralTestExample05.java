package section10.class01;

import com.itvillage.section10.class00.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * 1개 이상의 emit 된 데이터를 한꺼번에 검증
 */
public class StepVerifierGeneralTestExample05 {
    @Test
    public void divideByTwoTest() {
        Flux<Integer> source = Flux.just(2, 4, 6, 8, 10);
        StepVerifier
                .create(GeneralExample.divideByTwo(source))
                .expectSubscription()
                .expectNext(1, 2, 3, 4, 5)
                .expectComplete()
                .verify();
    }
}
