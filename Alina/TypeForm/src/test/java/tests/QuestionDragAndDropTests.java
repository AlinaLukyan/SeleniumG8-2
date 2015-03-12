package tests;

import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuestionDragAndDropTests extends BaseTest{


    @Test
    public void dragAndDropWelcomeScreen() {
        TypeFormPage typeFormPage = new TypeFormPage(driver);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        WelcomeScreenConstructorPage welcomeScreenConstructorPage = typeFormBuilderPage.dragAndDropWelcomeScreen();

        Assert.assertTrue(welcomeScreenConstructorPage.isNewWelcomeScreenBuilderOpened());
    }

}
