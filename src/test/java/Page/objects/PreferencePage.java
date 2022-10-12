package Page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;


public class PreferencePage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@id='onetrust-banner-sdk']")
    private WebElement popUpAcceptCookies;


    @FindBy(xpath = "//button[@id ='onetrust-accept-btn-handler']")
    private WebElement buttonAcceptCookies;

    @FindBy(id = "wayfinderHeadline")
    private WebElement pageSettings;

    @FindBy(id = "industry-select")
    private WebElement industryButton;

    @FindBy(id = "language-select")
    private WebElement dropDownLanguageField;

    @FindBy(xpath = "//select[@class='js-form-control form-control custom-select']")
    private WebElement OptionsOfLanguages;

    @FindBy(xpath = "//ul[@aria-labelledby='language-select']")
    private WebElement clickOptionsOfLanguages;

    @FindBy(xpath = "//li[@data-value='de']")
    private WebElement oneOfOptionsOfLanguages;


    private Select select;


    public PreferencePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAcceptAllCookies() {
        WaitForElement.waitUntilElementIsVisible(popUpAcceptCookies);
        buttonAcceptCookies.click();
        logger.info("Click On Accept All Cookies");
    }

    public String getIndustryButtonLable() {
        return industryButton.findElement(By.xpath("./label")).getAttribute("value");
    }

    public Select selectingOptionsFromLanguageField() {
        select = new Select(OptionsOfLanguages);
        logger.info("Selecting Options From Language Field");
        return select;
    }

    public void clickLanguageFieldButton() {
        WaitForElement.waitUntilElementIsVisible(clickOptionsOfLanguages);
        dropDownLanguageField.click();
        logger.info("Topic Button click");
    }

    public void selectOnLanguagesOption() {
        oneOfOptionsOfLanguages.click();
    }

    public void clickComeBackMainPage() {



    }


}

