package tests;

import com.app.pages.Header;
import com.app.pages.LogInPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

    /**
     * Log in to the system first to perform any further tests
     */
    @Test
    public void logIn(){
        String username = "lukyanalina@gmail.com";
        String password = "qwerty+1";

        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.logIn(username, password);
    }

    @Test(enabled = false)
    public void signUp(){

    }

    @Test(enabled = false)
    public void logOut(){
        Header siteHeader = PageFactory.initElements(driver, Header.class);

        LogInPage logInPage = siteHeader.logOut();
        //TODO: Assert
    }
}
