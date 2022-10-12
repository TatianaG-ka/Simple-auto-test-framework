package Page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CareersPage {

    private Logger logger = LogManager.getRootLogger();


    public CareersPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(xpath = "//span[@class='site-name h3 font-amadeus ml-md-2 d-flex d-md-inline-flex mt-1 mt-md-0 mb-0']")
    private WebElement checkCareersElement;

    @FindBy(xpath = "//button[@id='sformButton']")
    private WebElement applyButton;


    public void clickOnApplyButton() {
        WaitForElement.waitUntilElementIsVisible(checkCareersElement);
        applyButton.click();
        logger.info("Click On Apply Button");
    }

}
