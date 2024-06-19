package com.bdd.cucumber.PageObjects;

import com.bdd.cucumber.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;
    @FindBy(id = "twotabsearchtextbox")
    private WebElement mobileSearch;
    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;
    @FindBy(css = "[data-component-type='s-search-result']")
    private List<WebElement> mobileList;
    @FindBy(id = "apb-browse-refinements-checkbox_5")
    private WebElement listBrands;
    @FindBy(css = "[data-component-type='s-search-result']")
    private WebElement firstProduct;
    @FindBy(css = "[aria-label='Prime Eligible']")
    private WebElement primeCheckBox;
    @FindBy(css = "[data-cy='delivery-recipe']")
    private WebElement deliveryDate;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct() {
        log.info("Searching for mobiles");
        mobileSearch.sendKeys("mobiles");

    }

    public void clickOnSearchBtn() {
        log.info("click on search button");
        searchButton.click();
    }

    public void visitLastItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mobileList.get(mobileList.size() - 1)).build().perform();

    }

    public void displayLastMobileDetails() {
        log.info(mobileList.get(mobileList.size() - 1).getText());
    }

    public void clickingOnFirstBrand() {
        log.info("clicking on first brand");
        Actions actions = new Actions(driver);
        actions.moveToElement(listBrands).click().build().perform();
    }

    public void displayFirstProduct() {
        log.info("getting first product details");
        firstProduct.getText();
    }

    public void clickOnPrime() {
        log.info("waiting for prime checkbox");
        waitForElement(By.id("apb-browse-refinements-checkbox_1"));
        primeCheckBox.click();
    }

    public void getDelivery() {
        log.info("get delivery details");
        log.info(deliveryDate.getText());
    }
}
