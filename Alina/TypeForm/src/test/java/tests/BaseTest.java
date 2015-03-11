package tests;

import com.app.pages.Header;
import com.app.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    WebDriver driver;
    public static final int DEFAULT_WAIT = 10;

//    @AfterTest
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.get("https://admin.typeform.com");
        logIn();
    }

    @Test
    public void logIn() {
        String username = "lukyanalina@gmail.com";
        String password = "qwerty+1";

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn(username, password);
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
//        driver.quit();
    }
}
