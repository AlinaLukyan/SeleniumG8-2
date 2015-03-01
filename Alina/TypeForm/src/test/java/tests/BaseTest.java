package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://admin.typeform.com");
    }

    @AfterClass
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.quit();

    }
}
