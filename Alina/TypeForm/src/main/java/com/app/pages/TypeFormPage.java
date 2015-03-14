package com.app.pages;


import com.app.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TypeFormPage {

    private WebDriver driver;

    @Autowired
    Actions action;

    @Autowired
    NewFormPage newFormPage;

    private WebElement newTypeFormButton;
    private List<WebElement> activeForms;
    private WebElement formGrid;
    private WebElement deleteButton;
    private List<WebElement> emptyTypeForms;

    @Value("${TypeFormPage.newTypeFormButton}")
    private String newTypeFormButtonLocator;
    @Value("${TypeFormPage.activeForms}")
    private String activeFormsLocator;
    @Value("${TypeFormPage.formGrid}")
    private String formGridLocator;
    @Value("${TypeFormPage.deleteButton}")
    private String deleteButtonLocator;
    @Value("${TypeFormPage.emptyTypeForms}")
    private String emptyTypeFormsLocator;

    public TypeFormPage(WebDriver driver){
        this.driver = driver;
//        super(driver);
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        action = new Actions(driver);
    }

    public int getTotalFormNumber() {
        activeForms = driver.findElements(Utils.getLocatorByType(activeFormsLocator));
        return activeForms.size();
    }

    /**
     * Start from scratch in creating your new type-form
     * @return
     */
    public NewFormPage addNewForm() {
        newTypeFormButton = driver.findElement(Utils.getLocatorByType(newTypeFormButtonLocator));
        action.moveToElement(newTypeFormButton).click().build().perform();
        return newFormPage;
    }

    /**
     * TODO: not in use, still much to be done
     * @param formName
     */
    public ConfirmDeletePage deleteFormsByName(String formName) {
        formGrid = driver.findElement(Utils.getLocatorByType(formGridLocator));
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
        emptyTypeForms = driver.findElements(Utils.getLocatorByType(emptyTypeFormsLocator));
        if (emptyTypeForms.size() == 0) {
            addNewForm();
        } else {
            emptyTypeForms.get(0).click();
        }
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        return new TypeFormBuilderPage(driver);
    }

    public void setNewTypeFormButtonLocator(String newTypeFormButtonLocator) {
        this.newTypeFormButtonLocator = newTypeFormButtonLocator;
    }

    public void setActiveFormsLocator(String activeFormsLocator) {
        this.activeFormsLocator = activeFormsLocator;
    }

    public void setFormGridLocator(String formGridLocator) {
        this.formGridLocator = formGridLocator;
    }

    public void setDeleteButtonLocator(String deleteButtonLocator) {
        this.deleteButtonLocator = deleteButtonLocator;
    }

    public void setEmptyTypeFormsLocator(String emptyTypeFormsLocator) {
        this.emptyTypeFormsLocator = emptyTypeFormsLocator;
    }
}
