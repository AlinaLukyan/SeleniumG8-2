package com.app.pages;


import com.app.utils.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TypeFormPage {

    private WebDriver driver;
    private Actions actions;
    private static final Logger LOG = LoggerFactory.getLogger(TypeFormPage.class);

    private WebElement newTypeFormButton;
    private List<WebElement> customForms;
    private WebElement formGrid;
    private WebElement deleteButton;
    private List<WebElement> emptyTypeForms;

    private String customFormsLocator = "TypeFormPage.customForms";
    private String newTypeFormButtonLocator = "TypeFormPage.newTypeFormButton";
    private String formNamesLocator = "TypeFormPage.formNames";
    private String deleteButtonLocator = "TypeFormPage.deleteButton";
    private String emptyTypeFormsLocator = "TypeFormPage.emptyTypeForms";

    public TypeFormPage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    public int getTotalCustomFormNumber() {
        customForms = driver.findElements(ConfigData.ui(customFormsLocator));
        return customForms.size();
    }

    /**
     * Start from scratch in creating your new type-form
     * @return
     */
    public NewFormPage addNewForm() {
        newTypeFormButton = driver.findElement(ConfigData.ui(newTypeFormButtonLocator));
        actions.moveToElement(newTypeFormButton).click().build().perform();
        return new NewFormPage(driver);
    }

    /**
     * The method deletes all the forms by the name provided
     */
    public ConfirmDeletePage deleteFormsByName(String formName) {
        List<WebElement> formNames = driver.findElements(ConfigData.ui(formNamesLocator));

        boolean isAnyDeleted = false;
        for(int i = 0; i < formNames.size(); i++) {
            if(formNames.get(i).getText().equals(formName)) {
                WebElement theDeleteButton = formNames.get(i).findElement(ConfigData.ui(deleteButtonLocator));
                actions.moveToElement(theDeleteButton).click().build().perform();
                isAnyDeleted = true;
                return null;
            }
        }

        if(isAnyDeleted == false) {
            System.out.println("Nothing has been deleted. There are no forms with a given name");
        }
        return new ConfirmDeletePage(driver);
    }

    /**
     * Find any empty type-form to add new questions in there.
     * If nothing is found create a new one.
     * @return
     */
    public TypeFormBuilderPage enterEmptyTypeForm() {
        emptyTypeForms = driver.findElements(ConfigData.ui(emptyTypeFormsLocator));
        if (emptyTypeForms.size() == 0) {
            addNewForm();
        } else {
            emptyTypeForms.get(0).click();
        }
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        return new TypeFormBuilderPage(driver);
    }
}
