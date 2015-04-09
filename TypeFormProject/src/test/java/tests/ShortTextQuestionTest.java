package tests;


import com.app.pages.TypeFormBuilderPage;
import com.app.pages.TypeFormPage;
import com.app.pages.questions.ShortTextQuestionPage;
import com.app.utils.ConfigData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class ShortTextQuestionTest extends BaseTest {

    private String shortText = "shortText";

    /**
     * The method creates a new short-text question in an empty form and then
     * checks if the text entered equals to the text in form builder page
     * TODO
     */
    @Test(enabled = false)
    public void addShortTextQuestion() throws IOException {

        Map dataMap = excelDriver.getData(ConfigData.getConfigValue(dataFile), "addShortTextQuestion");

        TypeFormPage typeFormPage = new TypeFormPage(driver);
        TypeFormBuilderPage typeFormBuilderPage = typeFormPage.enterEmptyTypeForm();
        ShortTextQuestionPage shortTextQuestionPage = typeFormBuilderPage.enterShortTextQuestionConstructor();
        typeFormBuilderPage = shortTextQuestionPage.enterQuestionText(dataMap.get(shortText).toString()).submitNewQuestion();

        //TODO
    }
}
