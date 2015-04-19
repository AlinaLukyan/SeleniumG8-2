package com.app.pages;

import com.app.utils.ConfigData;
import com.app.utils.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewFormPage {

    private WebDriver driver;
    private static final Logger LOG = Logger.getLogger(NewFormPage.class);

    private Utils utils;

    private WebElement formNameInput;
    private WebElement formLanguageSelectButton;
    private WebElement formTypeSelectButton;
    private WebElement buildButton;

    private String formNameInputLocator = "NewFormPage.formNameInput";
    private String formLanguageSelectButtonLocator = "NewFormPage.formLanguageSelectButton";
    private String formTypeSelectButtonLocator = "NewFormPage.formTypeSelectButton";
    private String buildButtonLocator = "NewFormPage.buildButton";
    private String formLanguageListLocator = "NewFormPage.formLanguageList";
    private String formTypeListLocator = "NewFormPage.formTypeList";

    public NewFormPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public NewFormPage withFormName(String formName) {
        formNameInput = driver.findElement(ConfigData.ui(formNameInputLocator));
        formNameInput.clear();
        formNameInput.sendKeys(formName);
        LOG.info("The name for the form is set to " + formName + ".");
        return this;
    }

    public NewFormPage withFormLanguage(String formLanguage){
        formLanguageSelectButton = driver.findElement(ConfigData.ui(formLanguageSelectButtonLocator));
        By listLocator = ConfigData.ui(formLanguageListLocator);
        utils.selectFromDropDown(formLanguageSelectButton, listLocator, formLanguage);
        LOG.info("Selected " + formLanguage + " language.");
        return this;
    }

    public NewFormPage withFormType(String formType) {
        formTypeSelectButton = driver.findElement(ConfigData.ui(formTypeSelectButtonLocator));
        By listLocator = ConfigData.ui(formTypeListLocator);
        utils.selectFromDropDown(formTypeSelectButton, listLocator, formType);
        LOG.info("Selected " + formType + " form type.");

        return this;
    }

    public TypeFormBuilderPage buildTypeForm() {
        buildButton = driver.findElement(ConfigData.ui(buildButtonLocator));
        buildButton.click();
        LOG.info("A new TypeForm has been built.");
        return new TypeFormBuilderPage(driver);
    }
}
