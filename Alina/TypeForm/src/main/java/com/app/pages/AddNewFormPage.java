package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alinka on 25/02/15.
 */
public class AddNewFormPage {

    WebDriver driver;
    Select select;

    @FindBy(how = How.XPATH, using = ".//*[@id='quickyform_name']")
    WebElement formName;

    @FindBy(how = How.XPATH, using = "html/body/div[7]/ul/li[1]/div")
    WebElement formLanguage;

    @FindBy(how = How.XPATH, using = "html/body/div[7]/ul/li[1]/div")
    WebElement formType;

    @FindBy(how = How.XPATH, using = ".//*[@id='add-form']/form/div[4]/input")
    WebElement buidButton;


    public AddNewFormPage(WebDriver driver){
        this.driver = driver;
    }

    public AddNewFormPage withFormName(String formName){
        this.formName.clear();
        this.formName.sendKeys(formName);
        return this;
    }

    public AddNewFormPage withFormLanguage(){
        driver.findElement(By.xpath(".//*[@id='s2id_quickyform_language']/a/div/b")).click();
        this.formLanguage.click();
//        new Select(this.formLanguage).selectByVisibleText(formLanguage);
        return this;
    }

    public AddNewFormPage withFormType(){
        driver.findElement(By.xpath(".//*[@id='s2id_quickyform_category']/a/div/b")).click();
        this.formType.click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        return this;
    }

    public TypeFormBuilderPage openFormBuilderPage(){
        this.buidButton.click();
        return PageFactory.initElements(driver, TypeFormBuilderPage.class);
    }

}
