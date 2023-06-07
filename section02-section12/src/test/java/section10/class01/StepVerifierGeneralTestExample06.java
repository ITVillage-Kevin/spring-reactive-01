package section10.class01;

import com.itvillage.section10.class00.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

/**
 * onNext signal 을 통해 emit 된 데이터의 개수를 검증하는 예제
 *  - 검증에 실패할 경우에는 StepVerifierOptions에서 지정한 Scenario Name이 표시된다.
 */
public class StepVerifierGeneralTestExample06 {
    @Test
    public void rangeNumberTest() {
        Flux<Integer> source = Flux.range(0, 1000);
        StepVerifier
                .create(GeneralExample.takeNumber(source, 500),
                        StepVerifierOptions.create().scenarioName("Verify from 0 to 499"))
                .expectSubscription()
                .expectNext(0)
                .expectNextCount(498)
                .expectNext(499) // TODO 값을 바꿔서 실패 예제 보여주기
                .expectComplete()
                .verify();
    }
}
