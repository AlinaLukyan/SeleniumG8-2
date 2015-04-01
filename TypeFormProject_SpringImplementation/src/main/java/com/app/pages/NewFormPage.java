package com.app.pages;

import com.app.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class NewFormPage {

    private WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(NewFormPage.class);

    @Autowired
    private Utils utils;
    @Autowired
    private TypeFormBuilderPage typeFormBuilderPage;

    private WebElement formNameInput;
    private WebElement formLanguageSelectButton;
    private WebElement formTypeSelectButton;
    private WebElement buildButton;

    @Value("${NewFormPage.formNameInput}")
    private String formNameInputLocator;
    @Value("${NewFormPage.formLanguageSelectButton}")
    private String formLanguageSelectButtonLocator;
    @Value("${NewFormPage.formTypeSelectButton}")
    private String formTypeSelectButtonLocator;
    @Value("${NewFormPage.buildButton}")
    private String buildButtonLocator;
    @Value("${NewFormPage.formLanguageList}")
    private String formLanguageListLocator;
    @Value("${NewFormPage.formTypeList}")
    private String formTypeListLocator;

    public NewFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewFormPage withFormName(String formName) {
        formNameInput = driver.findElement(Utils.getLocatorByType(formNameInputLocator));
        formNameInput.clear();
        formNameInput.sendKeys(formName);
        return this;
    }

    public NewFormPage withFormLanguage(String formLanguage){
        formLanguageSelectButton = driver.findElement(Utils.getLocatorByType(formLanguageSelectButtonLocator));
        By listLocator = Utils.getLocatorByType(formLanguageListLocator);
        utils.selectFromDropDown(formLanguageSelectButton, listLocator, formLanguage);
        return this;
    }

    public NewFormPage withFormType(String formType) {
        formTypeSelectButton = driver.findElement(Utils.getLocatorByType(formTypeSelectButtonLocator));
        By listLocator = Utils.getLocatorByType(formTypeListLocator);
        utils.selectFromDropDown(formTypeSelectButton, listLocator, formType);
        return this;
    }

    public TypeFormBuilderPage openFormBuilderPage() {
        buildButton = driver.findElement(Utils.getLocatorByType(buildButtonLocator));
        buildButton.click();
        return typeFormBuilderPage;
    }

    public void setFormNameInputLocator(String formNameInputLocator) {
        this.formNameInputLocator = formNameInputLocator;
    }

    public void setFormLanguageSelectButtonLocator(String formLanguageSelectButtonLocator) {
        this.formLanguageSelectButtonLocator = formLanguageSelectButtonLocator;
    }

    public void setFormTypeSelectButtonLocator(String formTypeSelectButtonLocator) {
        this.formTypeSelectButtonLocator = formTypeSelectButtonLocator;
    }

    public void setBuildButtonLocator(String buildButtonLocator) {
        this.buildButtonLocator = buildButtonLocator;
    }


    public void setFormLanguageListLocator(String formLanguageListLocator) {
        this.formLanguageListLocator = formLanguageListLocator;
    }

    public void setFormTypeListLocator(String formTypeListLocator) {
        this.formTypeListLocator = formTypeListLocator;
    }
}
