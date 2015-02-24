package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {

    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        //@Before
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua");
        //@Test
        WebElement luckyButton = driver.findElement(By.xpath("//button[@id='gbqfbb']"));
        luckyButton.click();

        if (driver.getCurrentUrl().equals("https://www.google.com/doodles"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");

        //@After
        driver.quit();

    }
}
