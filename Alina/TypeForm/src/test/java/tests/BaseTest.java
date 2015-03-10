package tests;

import com.app.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BaseTest {

    WebDriver driver;

//    @AfterTest
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://admin.typeform.com");

        logIn();
    }

    @Test
    public void logIn(){
        String username = "lukyanalina@gmail.com";
        String password = "qwerty+1";

        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.logIn(username, password);
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }
}
