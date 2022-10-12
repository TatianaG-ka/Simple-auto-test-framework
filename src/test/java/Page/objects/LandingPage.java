package Page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LandingPage {

    private Logger logger = LogManager.getRootLogger();


    @FindBy(linkText = "Careers")
    private WebElement careersLink;


    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnCareersLink() {
        WaitForElement.waitUntilElementIsClickable(careersLink);
        new Actions(DriverManager.getWebDriver()).moveToElement(careersLink).click().build().perform();
        careersLink.click();
        logger.info("Click On Careers Link");
    }

}






