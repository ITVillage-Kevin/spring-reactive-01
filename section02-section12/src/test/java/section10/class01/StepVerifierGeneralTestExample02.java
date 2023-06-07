package section10.class01;

import com.itvillage.section10.class00.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/***
 * expectNext()를 사용하여 emit 된 n 개의 데이터를 검증하는 예제
 */
public class StepVerifierGeneralTestExample02 {
    @Test
    public void sayHelloReactorTest() {
        StepVerifier
                .create(GeneralExample.sayHelloReactor())
                .expectSubscription()
                .expectNext("Hello")
                .expectNext("Reactor")
                .expectComplete()
                .verify();
    }
}
