package tests;

import com.app.pages.Header;
import com.app.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(locations={
        "/page-context.xml",
        "/test-context.xml",
})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver driver;
    @Autowired
    private LogInPage logInPage;
    @Autowired
    private Header header;

    @Value("${url}")
    private String url;
    @Value("${userName}")
    private String userName;
    @Value("${userPassword}")
    private String password;

    public static final int DEFAULT_WAIT = 30;

    @BeforeMethod
    public void setUp() throws Exception {
//        WebDriverFactory.setMode(webDriverFactoryMode);
//        driver = WebDriverFactory.getDriver(desiredCapabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.get(url);
        logInPage.logIn(userName, password);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
