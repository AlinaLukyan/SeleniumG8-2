package com.app.pages;

import com.app.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NewFormPage {

    private WebDriver driver;

    private WebElement formNameInput;
    private WebElement formLanguageSelectButton;
    private WebElement formTypeSelectButton;
    private WebElement buildButton;

    @Autowired
    private TypeFormBuilderPage typeFormBuilderPage;

    @Value("${NewFormPage.formNameInput}")
    private String formNameInputLocator;
    @Value("${NewFormPage.formLanguageSelectButton}")
    private String formLanguageSelectButtonLocator;
    @Value("${NewFormPage.formTypeSelectButton}")
    private String formTypeSelectButtonLocator;
    @Value("${NewFormPage.buildButton}")
    private String buildButtonLocator;

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
        formLanguageSelectButton.click();
        List<WebElement> options = formLanguageSelectButton.findElements(By.xpath("//div[@class='select2-result-label']"));
        for (WebElement element : options){
            if(element.getText().equals(formLanguage)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public NewFormPage withFormType(String formType) {
        formTypeSelectButton = driver.findElement(Utils.getLocatorByType(formTypeSelectButtonLocator));
        formTypeSelectButton.click();
        List<WebElement> options = formTypeSelectButton.findElements(By.xpath("//div[@class='select2-result-label']"));
        for (WebElement element : options) {
            if (element.getText().equals(formType)) {
                element.click();
                break;
            }
        }
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

}
