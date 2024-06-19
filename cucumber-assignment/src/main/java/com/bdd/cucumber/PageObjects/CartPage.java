package com.bdd.cucumber.PageObjects;

import com.bdd.cucumber.AbstractComponents.AbstractComponent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;
    @FindBy(css = "span#productTitle")
    private WebElement productTitle;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private List<WebElement> cartButton;
    @FindBy(id = "attach-sidesheet-view-cart-button")
    private WebElement cartPreview;
    @FindBy(id = "quantity")
    private WebElement productQuantity;
    @FindBy(css = ".a-dropdown-item>a")
    private List<WebElement> dropDownQuantities;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void displayProductDetails() {
        log.info(productTitle.getText());
    }

    public void addToCart() {
        log.info("Clicking on add to cart{}", cartButton.size());
        if (cartButton.size() > 1) {
            cartButton.get(1).click();
        } else {
            cartButton.get(0).click();
        }

        log.info("Item added to cart");
        log.info("Waiting for cart preview");
        waitForElement(By.id("attach-sidesheet-view-cart-button"));
        log.info("Clicking on cart button");
        cartPreview.click();
    }

    public void verifyQuantity() {
        Select select = new Select(driver.findElement(By.id("quantity")));
        log.info("checking the cart quantity");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "1");

    }


}
