package Page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@class='sii-o-nav-bar__item__nav-top']/a")
    private WebElement contactButton;


    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public void clickOnContactButton() {
        WaitForElement.waitUntilElementIsClickable(contactButton);
        contactButton.click();
        logger.info("Click On Contact Button");
    }
}
