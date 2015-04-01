package tests;


import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.ShortTextQuestionPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import com.app.utils.ConfigData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class NewQuestionTests extends BaseTest {

    private String welcomeText = "welcomeText";
    private String shortText = "shortText";

    /**
     * The method creates new welcome screen for an empty form and then
     * checks if the text entered equals to the text in form builder page
     */
    @Test
    public void addWelcomeScreen() throws IOException {

        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "addWelcomeScreen");

        TypeFormPage typeFormPage = new TypeFormPage(driver);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        WelcomeScreenConstructorPage welcomeScreenConstructorPage = typeFormBuilderPage.enterWelcomeScreenConstructor();
        typeFormBuilderPage = welcomeScreenConstructorPage.addWelcomeScreenText(dataMap.get(welcomeText).toString()).submitNewWelcomeScreen();

        Assert.assertEquals(typeFormBuilderPage.getWelcomeScreenText(), dataMap.get(welcomeText).toString(), "Both the text messages, entered and displayed, are equal");
    }

    /**
     * The method creates a new short-text question in an empty form and then
     * checks if the text entered equals to the text in form builder page
     * TODO
     */
    @Test
    public void addShortTextQuestion() throws IOException {

        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "addShortTextQuestion");

        TypeFormPage typeFormPage = new TypeFormPage(driver);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        ShortTextQuestionPage shortTextQuestionPage = typeFormBuilderPage.enterShortTextQuestionConstructor();
        typeFormBuilderPage = shortTextQuestionPage.enterQuestionText(dataMap.get(shortText).toString()).submitNewQuestion();

        //TODO
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
