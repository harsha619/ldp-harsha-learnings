package com.amazon.PageObjects;

import com.amazon.AbstractComponents.AbstractComponent;
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

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountSignIn).click().build().perform();
        log.info("entering email");
        email.sendKeys(properties.getProperty("EMAIL"));
        log.info("clicking continue");
        continueBtn.click();
        log.info("entering password");
        password.sendKeys(properties.getProperty("PASSWORD"));
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
        }
        catch(Exception e){
            log.info("skipped otp verification");
        };

    }
}
