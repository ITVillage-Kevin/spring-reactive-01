package section10.class01;

import com.itvillage.section10.class00.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * - verifyComplete()을 사용하여 검증 실행 및 기대값으로 onComplete signal 이 맞는지 검증하는 예제
 *  - as(description)를 사용해서 실패한 expectXXXX()에게 description 을 지정할 수 있다.
 */
public class StepVerifierGeneralTestExample03 {
    @Test
    public void sayHelloReactorTest() {
        StepVerifier
                .create(GeneralExample.sayHelloReactor())
                .expectSubscription()
                .as("# expect subscription")
                .expectNext("Hi")
                .as("# expect Hi")
                .expectNext("Reactor")
                .as("# expect Reactor")
                .verifyComplete();
    }
}
