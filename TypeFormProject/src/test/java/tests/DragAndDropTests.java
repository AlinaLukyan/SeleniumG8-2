package tests;

import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends BaseTest {

    @Test
    public void dragAndDropWelcomeScreen() {
        TypeFormPage typeFormPage = new TypeFormPage(driver);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        WelcomeScreenConstructorPage welcomeScreenConstructorPage = typeFormBuilderPage.dragAndDropWelcomeScreen();

        Assert.assertTrue(welcomeScreenConstructorPage.isNewWelcomeScreenBuilderOpened());
    }

    @Test
    public void dragAndDropShortTextQuestion() {

    }

    @Test
    public void dragAndDropMultipleChoiceQuestion() {

    }

    @Test
    public void dragAndDropLongTextQuestion() {

    }

    @Test
    public void dragAndDropPictureChoiceQuestion() {

    }

    @Test
    public void dragAndDropStatementQuestion() {

    }

    @Test
    public void dragAndDropQuestionGroup() {

    }

    @Test
    public void dragAndDropDropDownQuestion() {

    }

    @Test
    public void dragAndDropYesNoQuestion() {

    }

    @Test
    public void dragAndDropEmailQuestion() {

    }

    @Test
    public void dragAndDropRatingQuestion() {

    }

    @Test
    public void dragAndDropLegalQuestion() {

    }

    @Test
    public void dragAndDropOpinionScaleQuestion() {

    }

    @Test
    public void dragAndDropNumberQuestion() {

    }

    @Test
    public void dragAndDropWebsiteQuestion() {

    }

    @Test
    public void dragAndDropFileUploadQuestion() {

    }

    @Test
    public void dragAndDropPaymentQuestion() {

    }

    @Test
    public void dragAndDropThankYouScreen() {

    }
}
