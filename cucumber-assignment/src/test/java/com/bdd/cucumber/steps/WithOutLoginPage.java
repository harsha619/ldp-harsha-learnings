package com.bdd.cucumber.steps;

import com.bdd.cucumber.PageObjects.CartPage;
import com.bdd.cucumber.PageObjects.DealsPage;
import com.bdd.cucumber.PageObjects.NavigationPage;
import com.bdd.cucumber.PageObjects.ProductPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WithOutLoginPage {
    String baseUrl = "https://www.amazon.in/";

    DealsPage dealsPage;
    CartPage cartPage;
    ProductPage productPage;
    NavigationPage navigationPage;
    WebDriver driver;

    @Before
    public void openAmazonWebsite() {
        driver = Hooks.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dealsPage = new com.bdd.cucumber.PageObjects.DealsPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        navigationPage = new NavigationPage(driver);
    }

    @When("User clicking on today deals")
    public void clickOnTodayDeals() {
        dealsPage.todayDeals();
    }

    @When("User click on third deal")
    public void user_click_on_third_deal() {
        dealsPage.getThirdDeal();
    }

    @When("Add minimum quantity of item")
    public void add_minimum_quantity_of_item() {
        cartPage.addToCart();
    }

    @When("User search for {string}")
    public void user_search_for(String string) {
        productPage.searchForProduct();
    }

    @When("User scroll down to last mobile")
    public void user_scroll() {
        productPage.visitLastItem();
    }

    @When("User click on search button")
    public void clickOnSearchBtn() {
        productPage.clickOnSearchBtn();
    }

    @Then("verify the Last mobile displayed")
    public void verifyLastMobileDetails() {
        productPage.displayLastMobileDetails();
    }

    @Then("verify the cart item with minimum quantity")
    public void verify_the_cart_item_with_minimum_quantity() {
        cartPage.verifyQuantity();
    }


    @When("User will navigate to navbar")
    public void user_will_navigate_to_navbar() {
        navigationPage.clickOnNavBar();
    }

    @When("User click on mobiles")
    public void user_click_on_mobiles() {

        navigationPage.selectMobiles();
    }

    @When("User will click on mobiles section")
    public void user_will_click_on_mobiles_section() {
        navigationPage.selectAllMobiles();
    }

    @When("User will click on first brand")
    public void user_will_click_on_first_brand() {
        productPage.clickingOnFirstBrand();
    }

    @Then("verify the mobiles on first page")
    public void verify_the_mobiles_on_first_page() {
        productPage.displayFirstProduct();
    }

}
