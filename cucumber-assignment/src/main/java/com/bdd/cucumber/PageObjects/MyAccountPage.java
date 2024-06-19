package com.bdd.cucumber.PageObjects;

import com.bdd.cucumber.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationPage.class);
    WebDriver driver;
    @FindBy(id = "nav-orders")
    private WebElement orderBtn;
    @FindBy(id = "time-filter")
    private WebElement timeFilter;
    @FindBy(id = "nav-link-accountList")
    private WebElement myAccount;
    @FindBy(css = "[data-card-identifier='PaymentOptions']")
    private WebElement myPayments;
    @FindBy(css = "[data-card-identifier='AddressesAnd1Click']")
    private WebElement myAddress;
    @FindBy(id = "ya-myab-address-add-link")
    private WebElement addAddress;
    @FindBy(css = "[name='address-ui-widgets-enterAddressFullName']")
    private WebElement fullName;
    @FindBy(css = "[name='address-ui-widgets-enterAddressPhoneNumber']")
    private WebElement phoneNumber;
    @FindBy(css = "[name='address-ui-widgets-enterAddressPostalCode']")
    private WebElement pinCode;
    @FindBy(css = "[name='address-ui-widgets-enterAddressLine1']")
    private WebElement address;
    @FindBy(css = "[aria-labelledby='address-ui-widgets-form-submit-button-announce']")
    private WebElement addressSubmitBtn;

    @FindBy(xpath = "//select[@name='address-ui-widgets-enterAddressStateOrRegion']")
    private WebElement selectState;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getMyOrders() {
        log.info("clicking on my order");
        orderBtn.click();

    }

    public void gotoLastYear() {
        log.info("checking my orders");
        waitForElement(By.className("your-orders-content-container"));

        Select select = new Select(timeFilter);
        select.selectByIndex(3);
    }

    public void clickOnMyAccount() {
        log.info("clicking on my account");
        myAccount.click();
    }

    public void getMyPayments() {

        log.info("clicking on my payments");
        myPayments.click();

    }

    public void verifyPaymentPage() {
        waitForElement(By.id("walletTitleRow"));
    }

    public void clickOnMyAddress() {
        log.info("clicking on my address");
        myAddress.click();
    }

    public void addAddress() {
        log.info("Add address");
        waitForElement(By.id("ya-myab-address-add-link"));
        addAddress.click();
        log.info("waiting for address form");
        waitForElement(By.id("address-ui-widgets-enterAddressFullName"));
    }

    public void enterFullName() {
        log.info("filling address form", properties.getProperty("BASE_URL"));
        fullName.sendKeys("abc", properties.getProperty("NAME"));
    }

    public void enterPhoneNumber() {
        phoneNumber.sendKeys(properties.getProperty("PHONE_NUMBER"));
    }

    public void enterPinCode() {
        pinCode.sendKeys(properties.getProperty("PIN_CODE"));
    }

    public void enterDoorNo() {
        address.sendKeys(properties.getProperty("ADDRESS"));
    }

    public void submitAddress() {

        log.info("waiting for state");
        waitForCityName(selectState, "ANDHRA PRADESH");
        log.info("clicking on add address");
        addressSubmitBtn.click();
    }


}

