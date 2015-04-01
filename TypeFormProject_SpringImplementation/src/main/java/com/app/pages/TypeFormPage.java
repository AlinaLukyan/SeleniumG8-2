package com.app.pages;


import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TypeFormPage {

    private WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(TypeFormPage.class);

    @Autowired
    private Actions action;
    @Autowired
    private NewFormPage newFormPage;
    @Autowired
    private TypeFormBuilderPage typeFormBuilderPage;
    @Autowired
    private ConfirmDeletePage confirmDeletePage;

    private WebElement newTypeFormButton;
    private List<WebElement> customForms;
    private WebElement formGrid;
    private WebElement deleteButton;
    private List<WebElement> emptyTypeForms;

    @Value("${TypeFormPage.newTypeFormButton}")
    private String newTypeFormButtonLocator;
    @Value("${TypeFormPage.customForms}")
    private String customFormsLocator;
    @Value("${TypeFormPage.formGrid}")
    private String formGridLocator;
    @Value("${TypeFormPage.deleteButton}")
    private String deleteButtonLocator;
    @Value("${TypeFormPage.emptyTypeForms}")
    private String emptyTypeFormsLocator;
    @Value("${TypeFormPage.formNamesLocator}")
    private String formNamesLocator;

    public TypeFormPage(WebDriver driver){
        this.driver = driver;
    }

    public int getTotalCustomFormNumber() {
        customForms = driver.findElements(Utils.getLocatorByType(customFormsLocator));
        return customForms.size();
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
     * The method deletes all the forms by the name provided
     */
    public ConfirmDeletePage deleteFormsByName(String formName) {
        List<WebElement> formNames = driver.findElements(Utils.getLocatorByType(formNamesLocator));

        boolean isAnyDeleted = false;
        for(int i = 0; i < formNames.size(); i++) {
            if(formNames.get(i).getText().equals(formName)) {
                WebElement theDeleteButton = formNames.get(i).findElement(Utils.getLocatorByType(deleteButtonLocator));
                action.moveToElement(theDeleteButton).click().build().perform();
                isAnyDeleted = true;
                return null;
            }
        }

        if(isAnyDeleted == false) {
            System.out.println("Nothing has been deleted. There are no forms with a given name");
        }
        return confirmDeletePage;
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
        return typeFormBuilderPage;
    }

    public void setNewTypeFormButtonLocator(String newTypeFormButtonLocator) {
        this.newTypeFormButtonLocator = newTypeFormButtonLocator;
    }

    public void setCustomFormsLocator(String customFormsLocator) {
        this.customFormsLocator = customFormsLocator;
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

    public void setFormNamesLocator(String formNamesLocator) {
        this.formNamesLocator = formNamesLocator;
    }
}
