package com.bdd.cucumber.PageObjects;

import com.bdd.cucumber.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigationPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(NavigationPage.class);
    private final Actions action;
    WebDriver driver;
    @FindBy(id = "nav-hamburger-menu")
    private WebElement navMenu;
    @FindBy(css = "[data-menu-id='8']")
    private WebElement mobileComputer;
    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']/li[3]/a")
    private WebElement allMobilePhones;

    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public void selectMobiles() {

        log.info("clicking on mobile and computers");
        waitForWebElement(mobileComputer);
        action.moveToElement(mobileComputer).click().build().perform();


    }

    public void clickOnNavBar() {
        log.info("clicking nav maenu");
        navMenu.click();
    }

    public void selectAllMobiles() {
        log.info("clicking on all mobile phones");
        waitForWebElement(allMobilePhones);
        log.info("waited for all mobiles");
        action.moveToElement(allMobilePhones).click().build().perform();
    }

}
