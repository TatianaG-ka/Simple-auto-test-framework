package Page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.io.File;


public class ContactForm {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "surname")
    private WebElement surnameFiled;

    @FindBy(xpath = "//span[@class='sii-a-icon sii-m-cookies__container__close__icon']")
    private WebElement crossIcon;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "Zebra_Form_error_message_email")
    private WebElement messageLabel;

    @FindBy(id = "upload_file")
    private WebElement fileUpload;

    @FindBy(id = "submit_btn")
    private WebElement uploadButton;

    @FindBy(xpath = "//div[@class='sii-m-drag-and-drop__uploaded-files']")
    private WebElement uploadedFiles;

    @FindBy(id = "category_contact")
    private WebElement optionsOfTopic;

    @FindBy(xpath = "//span[@class='sii-a-button__subtitle -is-required']")
    private WebElement topicButton;

    @FindBy(linkText = "Szukam szkoleń")
    private WebElement oneOfOptions;

    private Select select;


    public ContactForm() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoNameField(String name) {
        WaitForElement.waitUntilElementIsVisible(nameField);
        nameField.clear();
        nameField.sendKeys(name);
        logger.info("Type Into Name Field{}", name);
    }

    public void typeIntoSurnameField(String surname) {
        surnameFiled.clear();
        surnameFiled.sendKeys(surname);
        logger.info("typeIntoSurnameField{}", surname);
    }

    public void clickOnSubmitButton() {
        new Actions(DriverManager.getWebDriver()).moveToElement(submitButton).click().build().perform();
        crossIcon.click();
        submitButton.click();
        logger.info("Click On Submit Button");
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Return warning message was:{}", warningText);
        return warningText;
    }

    public void chooseFileUpload() {
        File file = new File("src/test/resources/testfile.docx");
        fileUpload.sendKeys(file.getAbsolutePath());

        logger.info("Choose File Upload");
    }

    public void clickOnUploadButton() {
        uploadButton.click();
        logger.info("Click On Upload Button");
    }

    public String getUploadedFiles() {
        String uploadedText = uploadedFiles.getText();
        logger.info("Get Uploaded Files");
        return uploadedText;
    }

    public Select selectingOptionsFromDropDown() {
        select = new Select(optionsOfTopic);
        logger.info("Selecting Options From DropDown");
        return select;
    }

    public void chooseOption() {
        topicButton.click();
        logger.info("Topic Button click");
        oneOfOptions.click();
        logger.info("Choose one of Options");
        logger.info("Choose Option");
    }

}
