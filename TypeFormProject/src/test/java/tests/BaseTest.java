package tests;

import com.app.pages.LogInPage;
import com.app.utils.ConfigData;
import com.app.utils.DriverEventListener;
import com.app.utils.ExcelDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
    protected EventFiringWebDriver driver;
    protected ExcelDriver excelDriver;

    protected String dataFile = "DATA_FILE";
    private String userName = "userName";
    private String userPassword = "userPassword";
    private DesiredCapabilities fireFox = DesiredCapabilities.firefox();

    protected String url = ConfigData.getConfigValue("url");

    protected static final Logger LOG = Logger.getLogger(BaseTest.class);

    public static final int DEFAULT_WAIT = 30;

    @BeforeClass ()
    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
        webDriver = WebDriverFactory.getDriver(fireFox);
        driver = new EventFiringWebDriver(webDriver);
        DriverEventListener eventListener = new DriverEventListener();
        driver.register(eventListener);

        excelDriver = new ExcelDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.get(url);
        logIn();
    }

    @BeforeMethod
    public void methodSetUp() throws IOException {
        webDriver = WebDriverFactory.getDriver(fireFox);
    }

    public void logIn() throws IOException {
        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "logInSheet");
        String name = dataMap.get(userName).toString();
        String password = dataMap.get(userPassword).toString();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn(name, password);
    }

    @AfterClass
    public void TearDown() throws SQLException {
        WebDriverFactory.dismissDriver(webDriver);
    }
}
