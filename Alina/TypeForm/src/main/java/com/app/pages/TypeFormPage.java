package com.app.pages;


import com.app.libs.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TypeFormPage {

    WebDriver driver;
    Actions action;

    WebElement newTypeFormButton;
    List<WebElement> activeForms;
    WebElement formGrid;
    WebElement deleteButton;
    List<WebElement> emptyTypeForms;


    public TypeFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

//    private void initElements() {
//        newTypeFormButton = driver.findElement(ConfigData.ui("TypeFormPage.newTypeFormButton"));
//        activeForms = driver.findElements(ConfigData.ui("TypeFormPage.activeForms"));
//        formGrid = driver.findElement(ConfigData.ui("TypeFormPage.formGrid"));
//        deleteButton = driver.findElement(ConfigData.ui("TypeFormPage.deleteButton"));
//        emptyTypeForms = driver.findElements(ConfigData.ui("TypeFormPage.emptyTypeForms"));
//    }

    public int getTotalFormNumber() {
        activeForms = driver.findElements(ConfigData.ui("TypeFormPage.activeForms"));
        return activeForms.size();
    }

    /**
     * Start from scratch in creating your new type-form
     * @return
     */
    public NewFormPage addNewForm() {
        newTypeFormButton = driver.findElement(ConfigData.ui("TypeFormPage.newTypeFormButton"));
        action.moveToElement(newTypeFormButton).click().build().perform();
        return new NewFormPage(driver);
    }

    /**
     * TODO: not in use, still much to be done
     * @param formName
     */
    public ConfirmDeletePage deleteFormsByName(String formName) {
        formGrid = driver.findElement(ConfigData.ui("TypeFormPage.formGrid"));
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
        return new ConfirmDeletePage(driver);
    }

    /**
     * Find any empty type-form to add new questions in there.
     * If nothing is found create a new one.
     * @return
     */
    public TypeFormBuilderPage enterEmptyTypeForm() {
        emptyTypeForms = driver.findElements(ConfigData.ui("TypeFormPage.emptyTypeForms"));
        if (emptyTypeForms.size() == 0) {
            addNewForm();
        } else {
            emptyTypeForms.get(0).click();
        }
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        return new TypeFormBuilderPage(driver);
    }
}
