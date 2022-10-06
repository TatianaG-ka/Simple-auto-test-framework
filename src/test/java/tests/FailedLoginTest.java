package tests;

import Page.objects.ContactForm;
import Page.objects.LandingPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class FailedLoginTest extends TestBase {

    @Test
    public void asUserTryToFilledFieldsToContactForm() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnContactButton();

        ContactForm contactForm = new ContactForm();
        contactForm.typeIntoNameField("2tt");
        contactForm.typeIntoSurnameField("gol");
        contactForm.clickOnSubmitButton();
        String warningMessage = contactForm.getWarningMessage();
        assertEquals("Adres e-mail jest wymagany", warningMessage);


        contactForm.chooseFileUpload();
        contactForm.clickOnUploadButton();

        String uploadedFiles = contactForm.getUploadedFiles();
        assertEquals(uploadedFiles, "Załączony plik:\n" + "testfile.docx");


        List<WebElement> options = contactForm.selectingOptionsFromDropDown().getOptions();
        List<String> namesOfOptions = new ArrayList<>();

        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }
        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Temat");
        expectedNamesOfOptions.add("Szukam Pracy");
        expectedNamesOfOptions.add("Chcę Zostać Klientem");
        expectedNamesOfOptions.add("Szukam Szkoleń");
        expectedNamesOfOptions.add("Reprezentuję Media");
        expectedNamesOfOptions.add("Mam Pytanie O RODO");
        expectedNamesOfOptions.add("Inne");
        assertEquals(namesOfOptions, expectedNamesOfOptions);
        contactForm.chooseOption();

    }

}