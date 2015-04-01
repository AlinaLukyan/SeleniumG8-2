package tests;

import com.app.pages.LogInPage;
import com.app.utils.ConfigData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class LogInTests extends BaseTest{

    private String userName = "userName";
    private String password = "userPassword";

    @Test (priority = 0)
    public void logIn() throws IOException {

        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "logInSheet");
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn(dataMap.get(userName).toString(), dataMap.get(password).toString());

        //TODO: assert
    }
}