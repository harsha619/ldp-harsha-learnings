package com.bdd.cucumber.PageObjects;

import com.bdd.cucumber.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationPage.class);
    WebDriver driver;
    @FindBy(id = "nav-link-accountList")
    private WebElement accountSignIn;
    @FindBy(css = "[type='email']")
    private WebElement email;
    @FindBy(css = "input#continue")
    private WebElement continueBtn;
    @FindBy(css = "[type='password']")
    private WebElement password;

    @FindBy(css = "#signInSubmit")
    private WebElement signInBtn;
    @FindBy(css = "[name='otpCode']")
    private WebElement otpCode;
    @FindBy(id = "auth-signin-button")
    private WebElement otpSignInBtn;
    private final Actions actions;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogin() {
        actions.moveToElement(accountSignIn).click().build().perform();
    }

    public void enterEmail() {
        log.info("entering email");
        email.sendKeys(properties.getProperty("EMAIL"));
    }

    public void clickOnContinue() {
        log.info("clicking continue");
        continueBtn.click();
    }

    public void enterPassword() {
        log.info("entering password");
        password.sendKeys(properties.getProperty("PASSWORD"));
    }

    public void clickOnSignIn() {

        log.info("clicking on signin button");
        signInBtn.click();
    }

    public void verifyOtp() throws InterruptedException {
        try {
            if (otpCode.isDisplayed()) {
                log.info("Enter otp");
                Thread.sleep(20000);
                otpSignInBtn.click();
            }
        } catch (Exception e) {
            log.info("skipped otp verification");
        }
    }
}
