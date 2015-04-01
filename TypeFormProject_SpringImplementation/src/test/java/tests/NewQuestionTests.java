package tests;


import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.ShortTextQuestionPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations={
        "/page-context.xml",
        "/test-context.xml",
})
public class NewQuestionTests extends BaseTest {

    @Autowired
    private TypeFormPage typeFormPage;
    @Autowired
    private TypeFormBuilderPage typeFormBuilderPage;
    @Autowired
    private WelcomeScreenConstructorPage welcomeScreenConstructorPage;
    @Autowired
    private ShortTextQuestionPage shortTextQuestionPage;

    @Value("${NewQuestionTests.welcomeText}")
    private String welcomeText;
    @Value("${NewQuestionTests.shortText}")
    private String shortText;

    /**
     * The method creates new welcome screen for an empty form and then
     * checks if the text entered equals to the text in form builder page
     */
    @Test
    public void addWelcomeScreen() {
        typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        welcomeScreenConstructorPage = typeFormBuilderPage.enterWelcomeScreenConstructor();
        typeFormBuilderPage = welcomeScreenConstructorPage.addWelcomeScreenText(welcomeText).submitNewWelcomeScreen();

        Assert.assertEquals(typeFormBuilderPage.getWelcomeScreenText(), welcomeText, "Both the text messages, entered and displayed, are equal");
    }

    /**
     * The method creates a new short-text question in an empty form and then
     * checks if the text entered equals to the text in form builder page
     * TODO
     */
    @Test
    public void addShortTextQuestion() {
        typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        shortTextQuestionPage = typeFormBuilderPage.enterShortTextQuestionConstructor();
        typeFormBuilderPage = shortTextQuestionPage.enterQuestionText(shortText).submitNewQuestion();
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
