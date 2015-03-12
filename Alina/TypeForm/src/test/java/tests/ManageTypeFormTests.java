package tests;

import com.app.pages.NewFormPage;
import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


@ContextConfiguration(locations={"/test-context.xml"})
public class ManageTypeFormTests extends BaseTest{

    /**
     * Create a new typeForm.
     * Start from scratch in your creation. No templates used.
     * User gets redirected to form builder on a new form creation.
     * New form name appears to be visible on builder screen
     */
    @Test
    public void createNewTypeForm(){
        //to be generated automatically
        String formName = "TypeForm1";
        String formType = "Pro";
        String formLanguage = "English";

        TypeFormPage typeFormPage = new TypeFormPage(driver);//PageFactory.initElements(driver, TypeFormPage.class);

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
    public void theNumberOfFormsShouldIncreaseByOne(){
        //to be generated automatically
        String formName = "TypeForm+1";
        String formType = "Pro";
        String formLanguage = "English";

        TypeFormPage typeFormPage = new TypeFormPage(driver);
        int currentFormNumber = typeFormPage.getTotalFormNumber();

        NewFormPage newFormPage = typeFormPage.addNewForm();
        TypeFormPage typeFormPage1 = newFormPage.withFormName(formName)
                .withFormLanguage(formLanguage)
                .withFormType(formType)
                .openFormBuilderPage()
                .goToHomePage();

        Assert.assertEquals(typeFormPage.getTotalFormNumber(), currentFormNumber+1);
    }


    /**
     * TODO: not valid
     */
    @Test(enabled = false)
    public void deleteTypeForm(){
        String formName = "TypeForm+1";

        TypeFormPage typeFormPage = new TypeFormPage(driver);
        typeFormPage.deleteFormsByName(formName);
    }
}
