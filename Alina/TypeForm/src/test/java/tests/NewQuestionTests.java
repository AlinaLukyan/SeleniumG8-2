package tests;


import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewQuestionTests extends BaseTest {


    /**
     * TODO:
     */
    @Test
    public void addWelcomeScreen() {
        String welcomeText = "Welcome text goes here. This is just a test";

        TypeFormPage typeFormPage = PageFactory.initElements(driver, TypeFormPage.class);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterNewTypeForm();
        WelcomeScreenConstructorPage welcomeScreenConstructorPage = typeFormBuilderPage.enterWelcomeScreenConstructor();
        welcomeScreenConstructorPage.addNewWelcomeScreen(welcomeText);

        Assert.assertEquals(welcomeScreenConstructorPage.getPreviewWelcomeText(), welcomeText, "Both the text messages, entered and displayed, are equal");
    }

    @Test
    public void addShortTextQuestion() {
        Assert.fail();

    }

    @Test
    public void addLongTextQuestion() {

    }

    @Test
    public void addStatementQuestion() {

    }

    @Test
    public void addDropdownQuestion() {

    }

    @Test
    public void addEmailQuestion() {

    }

    @Test
    public void addLegalQuestion() {

    }

    @Test
    public void addNumberQuestion() {

    }

    @Test
    public void addFileUploadQuestion() {

    }

    @Test
    public void addThankYouScreen() {

    }

    @Test
    public void addMultipleChoiceQuestion() {

    }

    @Test
    public void addPictureChoiceQuestion() {

    }

    @Test
    public void addQuestionGroupQuestion() {

    }

    @Test
    public void addYesNoQuestion() {

    }

    @Test
    public void addRatingQuestion() {

    }

    @Test
    public void addOpinionScaleQuestion() {

    }

    @Test
    public void addWebsiteQuestion() {

    }

    @Test
    public void addPaymentStripeQuestion() {

    }

}
