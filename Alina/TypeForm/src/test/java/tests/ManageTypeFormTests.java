package tests;

import com.app.pages.AddNewFormPage;
import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ManageTypeFormTests extends BaseTest{

    /**
     * Create a new typeForm.
     * User gets redirected to form builder on a new form creation.
     * New form name appears to be visible on builder screen
     */
    @Test
    public void createNewTypeForm(){
        //to be generated automatically
        String formName = "TypeForm1";
        String formType = "Pro";
        String formLanguage = "English";

        TypeFormPage typeFormPage = PageFactory.initElements(driver, TypeFormPage.class);

        AddNewFormPage addNewFormPage = typeFormPage.addNewForm();
        TypeFormBuilderPage typeFormBuilderPage = addNewFormPage.withFormName(formName)
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
    public void theNumberOfFormsShouldIncreaseByOne(){
        //to be generated automatically
        String formName = "TypeForm+1";
        String formType = "Pro";
        String formLanguage = "English";

        TypeFormPage typeFormPage = PageFactory.initElements(driver, TypeFormPage.class);
        int currentFormNumber = typeFormPage.getTotalFormNumber();

        AddNewFormPage addNewFormPage = typeFormPage.addNewForm();
        TypeFormPage typeFormPage1 = addNewFormPage.withFormName(formName)
                .withFormLanguage(formLanguage)
                .withFormType(formType)
                .openFormBuilderPage()
                .goToHomePage();

        Assert.assertEquals(typeFormPage.getTotalFormNumber(), currentFormNumber+1);
    }


    /**
     * TODO: not valid
     */
    @Test (enabled = false)
    public void deleteTypeForm(){
        String formName = "TypeForm+1";

        TypeFormPage typeFormPage = PageFactory.initElements(driver, TypeFormPage.class);
        typeFormPage.deleteFormsByName(formName);
    }
}
