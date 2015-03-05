package com.app.pages;


import com.app.libs.WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TypeFormPage {

    WebDriver driver;
    WebElements element;
    Actions action;

    @FindBy(how = How.XPATH, using = ".//*[@id='forms']//div[@class='upper admin-button turquoise']")
    WebElement newTypeFormButton;

    @FindBy(how = How.XPATH, using = "//ul[@id='forms']/li[contains(@class,'quickyform item active')]")
    List<WebElement> activeForms;

    @FindBy(how = How.XPATH, using = "//ul[@id='forms']")
    WebElement formGrid;

    @FindBy(how = How.XPATH, using = ".//*[@id='form-386001']/ul/li[4]/a")
    WebElement deleteButton;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'admin-button turquoise add-fields')]")
    List<WebElement> emptyTypeForms;


    public TypeFormPage(WebDriver driver){
        this.driver = driver;
        element = new WebElements(driver);
        action = new Actions(driver);
    }

    public int getTotalFormNumber() {
        return activeForms.size();
    }

    /**
     * Start from scratch in creating your new type-form
     * @return
     */
    public NewFormPage addNewForm() {
        action.moveToElement(newTypeFormButton).click().build().perform();
        return PageFactory.initElements(driver, NewFormPage.class);
    }

    /**
     * TODO: not in use, still much to be done
     * @param formName
     */
    public ConfirmDeletePage deleteFormsByName(String formName) {

        action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 100);

//        WebElement yesButton = driver.findElement(By.xpath(".//*[@id='dialog-ok']"));

        List<WebElement> formNames = formGrid.findElements(By.xpath("//span[@class='form-name']"));

        for(WebElement element : formNames) {
            if (element.getText().equals(formName)) {

                action.moveToElement(driver.findElement(By.xpath(".//*[@id='form-386001']/div[2]"))).click().build().perform();
//
//                wait.until(ExpectedConditions.visibilityOf(deleteButton));
//                deleteButton.click();
            }
        }
        return PageFactory.initElements(driver, ConfirmDeletePage.class);
    }

    /**
     * Find any empty type-form to add new questions in there.
     * If nothing is found create a new one.
     * @return
     */
    public TypeFormBuilderPage enterNewTypeForm() {
        if (emptyTypeForms.size() == 0) {
            addNewForm();
        } else {
            emptyTypeForms.get(0).click();
        }
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        return PageFactory.initElements(driver, TypeFormBuilderPage.class);
    }
}
