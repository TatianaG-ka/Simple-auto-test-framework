package Page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JobOferts {

    private Logger logger = LogManager.getRootLogger();


    @FindBy(xpath = "//div[@data-automation-id='introduce-yourself-section']")
    private WebElement introduceElementIsVisible;

    @FindBy(xpath = "//button[@data-automation-id='introduceYourselfButton']")
    private WebElement introduceYourselfButton;


    public JobOferts() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public void clickOnIntroduceYourselfButton() {
        WaitForElement.waitUntilElementIsVisible(introduceElementIsVisible);
        introduceYourselfButton.click();
        logger.info("Click On Introduce Yourself Button");
    }


}
