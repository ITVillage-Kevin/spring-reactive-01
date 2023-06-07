package section10.class03;

import com.itvillage.section10.class02.PublisherProbeExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.PublisherProbe;

public class PublisherProbeTestExample01 {
    @Test
    public void publisherProbeTest() {
        PublisherProbe<String> probe = PublisherProbe.of(PublisherProbeExample.useStandbyPower());

        StepVerifier
                .create(PublisherProbeExample.processWith(PublisherProbeExample.useMainPower(), probe.mono()))
                .expectNextCount(1)
                .verifyComplete();

        probe.assertWasSubscribed();
        probe.assertWasRequested();
        probe.assertWasNotCancelled();
    }
}
