package com.app.pages;

import com.app.utils.ConfigData;
import com.app.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewFormPage {

    private WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(NewFormPage.class);

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
        return this;
    }

    public NewFormPage withFormLanguage(String formLanguage){
        formLanguageSelectButton = driver.findElement(ConfigData.ui(formLanguageSelectButtonLocator));
        By listLocator = ConfigData.ui(formLanguageListLocator);
        utils.selectFromDropDown(formLanguageSelectButton, listLocator, formLanguage);
        return this;
    }

    public NewFormPage withFormType(String formType) {
        formTypeSelectButton = driver.findElement(ConfigData.ui(formTypeSelectButtonLocator));
        By listLocator = ConfigData.ui(formTypeListLocator);
        utils.selectFromDropDown(formTypeSelectButton, listLocator, formType);
        return this;
    }

    public TypeFormBuilderPage openFormBuilderPage() {
        buildButton = driver.findElement(ConfigData.ui(buildButtonLocator));
        buildButton.click();
        return new TypeFormBuilderPage(driver);
    }
}
