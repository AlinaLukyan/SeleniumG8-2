package tests;

import com.app.utils.ConfigData;
import com.app.utils.ExcelDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected ExcelDriver excelDriver;

    protected String dataFile = "DATA_FILE";
    private String url = "url";

    public static final int DEFAULT_WAIT = 30;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.get(ConfigData.getConfigValue(url));
        excelDriver = new ExcelDriver();
    }

    @BeforeMethod
    public void methodSetUp() {
        driver.get(ConfigData.getConfigValue(url));
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }
}
