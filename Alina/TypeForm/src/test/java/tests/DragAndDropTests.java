package tests;

import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends BaseTest {

    @Autowired
    TypeFormPage typeFormPage;
    @Autowired
    TypeFormBuilderPage typeFormBuilderPage;
    @Autowired
    WelcomeScreenConstructorPage welcomeScreenConstructorPage;

    @Test
    public void dragAndDropWelcomeScreen() {
        typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        welcomeScreenConstructorPage = typeFormBuilderPage.dragAndDropWelcomeScreen();

        Assert.assertTrue(welcomeScreenConstructorPage.isNewWelcomeScreenBuilderOpened());
    }

}
