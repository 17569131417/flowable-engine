package org.flowable.external.job.rest.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.flowable.external.job.rest.conf.BpmnEngineTestConfiguration;
import org.flowable.external.job.rest.conf.ExternalJobRestTestApplication;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * A meta annotation over {@link SpringBootTest} which sets the main class under test {@link ExternalJobRestTestApplication}.
 * Configures the test to run under a random port and registers the rest template.
 *
 * @author Filip Hrisafov
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ExtendWith(SpringExtension.class)
@ExtendWith(FlowableSpringExtension.class)
@SpringBootTest(classes = ExternalJobRestTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebClient(registerRestTemplate = true)
@Import({
        BpmnEngineTestConfiguration.class,
})
public @interface ExternalJobBpmnRestSpringBootTest {

}
