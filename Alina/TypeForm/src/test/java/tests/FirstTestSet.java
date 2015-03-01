package tests;

import com.app.pages.AddNewFormPage;
import com.app.pages.LogInPage;
import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestSet extends BaseTest {

    /**
     * Log in to the system first to perform any further tests
     */
    @BeforeClass
    public void logIn(){
        String username = "lukyanalina@gmail.com";
        String password = "qwerty+1";

        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.logIn(username, password);
    }

    /**
     * Create a new typeForm.
     * User gets redirected to form builder on a new form creation.
     * New form name appears to be visible on builder screen
     */
    @Test
    public void createNewTypeForm(){
        String formName = "TypeForm1";

        TypeFormPage typeFormPage = PageFactory.initElements(driver, TypeFormPage.class);

        AddNewFormPage addNewFormPage = typeFormPage.addNewForm();
        TypeFormBuilderPage typeFormBuilderPage = addNewFormPage.withFormName(formName)
                .withFormLanguage()  //no argument as of now
                .withFormType()
                .openFormBuilderPage();

        Assert.assertTrue(typeFormBuilderPage.getFormEntered().getText().contains(formName));
    }


    /**
     * Create a new typeForm.
     * Go to main TypeForm page.
     * The number of forms increases by one.
     */
    @Test
    public void theNumberOfFormsShouldIncreaseByOne(){
        String formName = "TypeForm+1";

        TypeFormPage typeFormPage = PageFactory.initElements(driver, TypeFormPage.class);
        int currentFormNumber = typeFormPage.getTotalFormNumber();
        System.out.println("Current number of forms is " + currentFormNumber);

        AddNewFormPage addNewFormPage = typeFormPage.addNewForm();
        TypeFormPage typeFormPage1 = addNewFormPage.withFormName(formName)
                .withFormLanguage()  //no arguments as of now
                .withFormType()      //no arguments as of now
                .openFormBuilderPage()
                .goToHomePage();

        System.out.println("Now the number of forms is " + typeFormPage.getTotalFormNumber());
        Assert.assertEquals(typeFormPage.getTotalFormNumber(), currentFormNumber+1);
    }

    @Test
    public void signUp(){

    }

    @Test
    public void deleteTypeForm(){
        driver.findElements(By.name("sgj"));

    }


    @Test(enabled = false)
    public void logOut(){
        driver.findElement(By.xpath(".//*[@id='header']/div[1]/ul/li[2]/a/div")).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='menu-logout']")).click();
    }


    @Test(enabled = false)
    public void methodLibrary(){
        driver.getTitle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.getCurrentUrl().equals("https://www.google.com/doodles");

//        wait.until(ExpectedConditions.visibilityOf(formEntered));

//        Select select = new Select(driver.findElement(By.xpath("//path_to_drop_down")));
//        select.deselectAll();
//        select.selectByVisibleText("Value1");
    }
}
