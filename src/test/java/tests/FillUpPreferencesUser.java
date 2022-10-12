package tests;

import Page.objects.*;
import driver.manager.DriverUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static navigation.ApplicationURLs.LOGIN_URL;

import static org.testng.AssertJUnit.assertEquals;

public class FillUpPreferencesUser extends TestBase {

    @Test
    public void asUserTryToFillUpPreferenceForm() {
        DriverUtils.navigateToPage(LOGIN_URL);

        PreferencePage preferencePage = new PreferencePage();
        preferencePage.clickOnAcceptAllCookies();
        preferencePage.getIndustryButtonLable();
        assertEquals("all", preferencePage.getIndustryButtonLable());

        List<WebElement> options = preferencePage.selectingOptionsFromLanguageField().getOptions();
        List<String> namesOfOptions = new ArrayList<>();

        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }
        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("English");
        expectedNamesOfOptions.add("Spanish");
        expectedNamesOfOptions.add("German");
        expectedNamesOfOptions.add("French");
        expectedNamesOfOptions.add("Italian");
        expectedNamesOfOptions.add("Portuguese");
        expectedNamesOfOptions.add("Russian");
        expectedNamesOfOptions.add("Chinese");
        expectedNamesOfOptions.add("Japanese");
        assertEquals(namesOfOptions, expectedNamesOfOptions);

        preferencePage.clickLanguageFieldButton();
        preferencePage.selectOnLanguagesOption();
        preferencePage.clickComeBackMainPage();

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnCareersLink();

        CareersPage careersPage = new CareersPage();
        careersPage.clickOnApplyButton();

        JobOferts jobOferts = new JobOferts();
        jobOferts.clickOnIntroduceYourselfButton();


        IntroduceYourself introduceYourself = new IntroduceYourself();
        introduceYourself.clickOnSubmitButton();
        introduceYourself.getMandatoryFields();

        String warningMessage = introduceYourself.getMandatoryFields();
        assertEquals(warningMessage, "3 Errors");

        introduceYourself.uploadFilePicker();
        introduceYourself.clickOnUploadButton();
        String uploadedFiles = introduceYourself.getUploadedFiles();
        assertEquals(uploadedFiles, "Successfully Uploaded!");
    }
}

