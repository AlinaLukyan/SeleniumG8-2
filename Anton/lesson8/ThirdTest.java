package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class ThirdTest {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        //@Before
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://admin.typeform.com/login");

        //@Test
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='_username']"));
        inputEmail.clear();
        inputEmail.sendKeys("lukyanalina@gmail.com");

        WebElement inputPass = driver.findElement(By.xpath("//input[@id='_password']"));
        inputPass.clear();
        inputPass.sendKeys("qwerty+1");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btnlogin']"));
        loginButton.click();

        if (driver.getCurrentUrl().equals("https://ankiweb.net/study/"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");

        //@After
        driver.quit();

    }
}
