package tests;

import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import com.app.utils.ConfigData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class WelcomeScreenTest extends BaseTest {

    private String welcomeText = "welcomeText";
    private String shortText = "shortText";

    /**
     * The method creates new welcome screen for an empty form and then
     * checks if the text entered equals to the text in form builder page
     */
    @Test(enabled = false)
    public void addWelcomeScreen() throws IOException {

        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "addWelcomeScreen");

        TypeFormPage typeFormPage = new TypeFormPage(driver);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        WelcomeScreenConstructorPage welcomeScreenConstructorPage = typeFormBuilderPage.enterWelcomeScreenConstructor();
        typeFormBuilderPage = welcomeScreenConstructorPage.addWelcomeScreenText(dataMap.get(welcomeText).toString()).submitNewWelcomeScreen();

        Assert.assertEquals(typeFormBuilderPage.getWelcomeScreenText(), dataMap.get(welcomeText).toString(), "Both the text messages, entered and displayed, are equal");
    }

    @Test
    public void dragAndDropWelcomeScreen() {
        TypeFormPage typeFormPage = new TypeFormPage(driver);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        WelcomeScreenConstructorPage welcomeScreenConstructorPage = typeFormBuilderPage.dragAndDropWelcomeScreen();

        Assert.assertTrue(welcomeScreenConstructorPage.isNewWelcomeScreenBuilderOpened());
    }
}
