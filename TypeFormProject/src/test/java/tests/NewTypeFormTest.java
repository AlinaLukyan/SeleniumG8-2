package tests;

import com.app.pages.Header;
import com.app.pages.NewFormPage;
import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.utils.ConfigData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class NewTypeFormTest extends BaseTest {

    private String formName;
    private String formType;
    private String formLanguage;

    /**
     * Create a new typeForm.
     * Start from scratch in your creation. No templates used.
     * User gets redirected to form builder on a new form creation.
     * New form name appears to be visible on builder screen
     */
    @Test
    public void createNewTypeForm() throws IOException {
        driver.navigate().to(url);
        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "createNewTypeForm");

        System.out.println("Value = " + dataMap.get("Login"));

        formName = dataMap.get("formName").toString();
        formType = dataMap.get("formType").toString();
        formLanguage = dataMap.get("formLanguage").toString();

        TypeFormPage typeFormPage = new TypeFormPage(driver);
        NewFormPage newFormPage = typeFormPage.addNewForm();
        TypeFormBuilderPage typeFormBuilderPage = newFormPage.withFormName(formName)
                .withFormLanguage(formLanguage)
                .withFormType(formType)
                .openFormBuilderPage();

        Assert.assertTrue(typeFormBuilderPage.getFormEntered().getText().contains(formName));
    }

    /**
     * Create a new typeForm.
     * Go to main TypeForm page.
     * The number of forms increases by one.
     */
    @Test
    public void theNumberOfFormsShouldIncreaseByOne() throws IOException {
        driver.navigate().to(url);
        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "createNewTypeForm");

        formName = dataMap.get("formName").toString();
        formType = dataMap.get("formType").toString();
        formLanguage = dataMap.get("formLanguage").toString();
        TypeFormPage typeFormPage = new TypeFormPage(driver);
        int currentFormNumber = typeFormPage.getTotalCustomFormNumber();

        NewFormPage newFormPage = typeFormPage.addNewForm();
        newFormPage.withFormName(formName)
                .withFormLanguage(formLanguage)
                .withFormType(formType)
                .openFormBuilderPage();
        Header header = new Header(driver);
        header.goToHomePage();

        Assert.assertEquals(typeFormPage.getTotalCustomFormNumber(), currentFormNumber + 1);
    }

    /**
     * The test deletes all the forms with a given name
     */
    @Test
    public void deleteTypeForm() {
        driver.navigate().to(url);
        TypeFormPage typeFormPage = new TypeFormPage(driver);
        int customFormNumber = typeFormPage.getTotalCustomFormNumber();

        int afterCount = typeFormPage.getTotalCustomFormNumber();
        typeFormPage.deleteFormsByName(formName);

//        Assert.assertEquals(, typeFormPage.getTotalFormNumber());
    }
}
