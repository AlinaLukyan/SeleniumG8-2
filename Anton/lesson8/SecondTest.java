package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class SecondTest {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        //@Before
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ankiweb.net/account/login");

        //@Test
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        inputEmail.clear();
        inputEmail.sendKeys("selenium-2@mail.ua");

        WebElement inputPass = driver.findElement(By.xpath("//input[@id='pass']"));
        inputPass.clear();
        inputPass.sendKeys("qwe123456");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='mitem3']"));
        loginButton.click();

        if (driver.getCurrentUrl().equals("https://ankiweb.net/study/"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");

        //@After
        driver.quit();

    }
}
