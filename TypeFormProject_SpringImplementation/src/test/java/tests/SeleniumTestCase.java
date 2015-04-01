package tests;

import com.app.utils.SeleniumTestCaseContext;
import com.app.utils.SeleniumTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = SeleniumTestCaseContext.class)
@TestExecutionListeners(listeners = {
        SeleniumTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class
})
public abstract class SeleniumTestCase extends AbstractTestNGSpringContextTests {

}
