package com.bdd.cucumber.PageObjects;

import com.bdd.cucumber.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DealsPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(css = "a[href='/deals?ref_=nav_cs_gb']")
    WebElement getDeals;
    @FindBy(css = "[data-testid='product-card']")
    List<WebElement> thirdDeal;

    public DealsPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void todayDeals() {
        getDeals.click();

    }

    public void getThirdDeal() {
        thirdDeal.get(3).click();
    }
}
