package tests;

import com.app.pages.Header;
import com.app.pages.NewFormPage;
import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


@ContextConfiguration(locations={
        "/page-context.xml",
        "/test-context.xml",
})
public class ManageTypeFormTests extends BaseTest {

    @Autowired
    TypeFormPage typeFormPage;
    @Autowired
    TypeFormBuilderPage typeFormBuilderPage;
    @Autowired
    NewFormPage newFormPage;
    @Autowired
    Header header;

    @Value("${formName}")
    String formName;
    @Value("${formType}")
    String formType;
    @Value("${formLanguage}")
    String formLanguage;

    /**
     * Create a new typeForm.
     * Start from scratch in your creation. No templates used.
     * User gets redirected to form builder on a new form creation.
     * New form name appears to be visible on builder screen
     */
    @Test
    public void createNewTypeForm(){
        newFormPage = typeFormPage.addNewForm();
        typeFormBuilderPage = newFormPage.withFormName(formName)
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
        int currentFormNumber = typeFormPage.getTotalFormNumber();

        newFormPage = typeFormPage.addNewForm();
        newFormPage.withFormName(formName)
                .withFormLanguage(formLanguage)
                .withFormType(formType)
                .openFormBuilderPage();
        header.goToHomePage();

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
