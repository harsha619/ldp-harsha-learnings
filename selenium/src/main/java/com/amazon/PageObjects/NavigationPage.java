package com.amazon.PageObjects;

import com.amazon.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigationPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(NavigationPage.class);
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

    }

    public void selectMobiles() throws InterruptedException {
        Actions action = new Actions(driver);
        log.info("clicking nav maenu");
        navMenu.click();
        log.info("clicking on mobile and computers");
        waitForWebElement(mobileComputer);
        action.moveToElement(mobileComputer).click().build().perform();
        log.info("clicking on all mobile phones");
        waitForWebElement(allMobilePhones);
        action.moveToElement(allMobilePhones).click().build().perform();

    }


}
