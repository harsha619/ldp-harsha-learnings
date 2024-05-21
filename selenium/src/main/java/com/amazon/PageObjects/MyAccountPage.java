package com.amazon.PageObjects;

import com.amazon.AbstractComponents.AbstractComponent;
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

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getMyOrders() {
        log.info("clicking on my order");
        orderBtn.click();
        log.info("checking my orders");
        waitForElement(By.className("your-orders-content-container"));

        Select select = new Select(timeFilter);
        select.selectByIndex(3);
    }

    public void getMyPayments() {
        log.info("clicking on my account");
        myAccount.click();
        log.info("clicking on my payments");
        myPayments.click();
        waitForElement(By.id("walletTitleRow"));
    }

    public void getMyAddress() {
        log.info("clicking on my account");
        myAccount.click();
        log.info("clicking on my address");
        myAddress.click();
        log.info("Add address");
        waitForElement(By.id("ya-myab-address-add-link"));
        addAddress.click();
        log.info("waiting for address form");
        waitForElement(By.id("address-ui-widgets-enterAddressFullName"));

    }

    public void fillAddressForm() {
        log.info("filling address form", properties.getProperty("BASE_URL"));
        fullName.sendKeys("abc", properties.getProperty("NAME"));
        phoneNumber.sendKeys(properties.getProperty("PHONE_NUMBER"));
        pinCode.sendKeys(properties.getProperty("PIN_CODE"));
        address.sendKeys(properties.getProperty("ADDRESS"));
        addressSubmitBtn.click();


    }


}

