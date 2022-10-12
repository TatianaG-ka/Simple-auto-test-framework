package Page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


public class IntroduceYourself {


    private Logger logger = LogManager.getRootLogger();

    public IntroduceYourself() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    @FindBy(xpath = "//span[@id='wd-FieldSet-NO_METADATA_ID-uid3-label']")
    private WebElement introduceElementIsVisibleTwice;

    @FindBy(xpath = "//button[@class='WBGN WASO WD-N WIHN WEGN']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@data-automation-id='errorWidgetBarIconCanvas']")
    private WebElement errorOfMandatoryField;


    @FindBy(xpath = "//input[@ata-automation-id='uploadElement']")
    private WebElement uploadFilePicker;

    @FindBy(xpath = "//button[@class='WBGN WFGN WASO WB-N WGII WBKI WKJI WPEN']")
    private WebElement selectFilesButton;

@FindBy(xpath = "//label[@class='WMNI']")
private WebElement uploadedFile;

    public void clickOnSubmitButton() {
        WaitForElement.waitUntilElementIsVisible(introduceElementIsVisibleTwice);
        submitButton.click();
    }

    public String getMandatoryFields() {
        WaitForElement.waitUntilElementIsVisible(errorOfMandatoryField);
        String warningText = errorOfMandatoryField.getText();
        logger.info("Get Mandatory Fields");
        return warningText;
    }


    public void uploadFilePicker () {
        File file = new File("src/test/resources/testfile.docx");
        uploadFilePicker.sendKeys(file.getAbsolutePath());
        logger.info("Choose File Upload");
    }

    public void clickOnUploadButton() {
        selectFilesButton.click();
        logger.info("Click On Upload Button");
    }

    public String getUploadedFiles() {
        String uploadedText = uploadedFile.getText();
        logger.info("Get Uploaded Files");
        return uploadedText;
    }

}
