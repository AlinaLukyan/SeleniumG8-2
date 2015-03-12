package tests;

import com.app.pages.Header;
import com.app.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(locations={"/test-context.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests implements InitializingBean {

    @Autowired
    WebDriver driver;

    @Autowired
    LogInPage logInPage;

    @Value("${url}")
    private String url;
    @Value("${userName}")
    private String userName;
    @Value("${userPassword}")
    private String password;

    public static final int DEFAULT_WAIT = 15;

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    //    @AfterTest
    @BeforeClass
    public void setUp() {
//        driver = new FirefoxDriver();
//        driver.get("https://admin.typeform.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.get(url);
        logInPage.logIn(userName, password);
    }

    @Test(enabled = false)
    public void signUp() {

    }

    @Test(enabled = false)
    public void logOut() {
        Header siteHeader = PageFactory.initElements(driver, Header.class);

        LogInPage logInPage = siteHeader.logOut();

        //TODO: Assert
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
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
}
