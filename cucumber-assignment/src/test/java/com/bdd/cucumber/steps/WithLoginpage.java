package com.bdd.cucumber.steps;

import com.bdd.cucumber.PageObjects.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WithLoginpage {
    String baseUrl = "https://www.amazon.in/";

    DealsPage dealsPage;
    CartPage cartPage;
    ProductPage productPage;
    NavigationPage navigationPage;
    WebDriver driver;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

    @Before
    public void openAmazonWebsite() {
        driver = Hooks.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dealsPage = new com.bdd.cucumber.PageObjects.DealsPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        navigationPage = new NavigationPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @When("User Click on login")
    public void user_click_on_login() {
        authenticationPage.clickOnLogin();
    }

    @When("User enter email address")
    public void user_enter_email_address() {
        authenticationPage.enterEmail();
    }

    @When("User click on continue")
    public void user_click_on_continue() {
        authenticationPage.clickOnContinue();
    }

    @When("User enter valid password")
    public void user_enter_valid_password() {
        authenticationPage.enterPassword();
    }

    @When("User click on Signin")
    public void user_click_on_signin() {
        authenticationPage.clickOnSignIn();
    }

    @Then("verify the home page")
    public void verify_the_home_page() throws InterruptedException {
        authenticationPage.verifyOtp();
    }

    @When("User click on prime checkBox")
    public void user_click_on_prime_check_box() {
        productPage.clickOnPrime();
    }

    @Then("verify the product delivery date")
    public void verify_the_product_delivery_date() {
        productPage.displayFirstProduct();
    }


    @When("User click on my orders")
    public void user_click_on_my_orders() {
        myAccountPage.getMyOrders();
    }

    @When("Select last year orders")
    public void select_last_year_orders() {
        myAccountPage.gotoLastYear();
    }

    @Then("verify the last year orders")
    public void verify_the_last_year_orders() {
        System.out.println("intp last ur");
    }


    @When("User click on my account")
    public void user_click_on_my_account() {
        myAccountPage.clickOnMyAccount();
    }

    @When("User click on my payments")
    public void user_click_on_my_payments() {
        myAccountPage.getMyPayments();
    }

    @Then("Verify payment details")
    public void verify_payment_details() {
        myAccountPage.verifyPaymentPage();
    }


    @When("User click on your addresses")
    public void user_click_on_your_addresses() {
        myAccountPage.clickOnMyAddress();
    }

    @When("User click on add address")
    public void user_click_on_add_address() {
        myAccountPage.addAddress();
    }

    @When("User enter valid full name")
    public void user_enter_valid_full_name() {
        myAccountPage.enterFullName();
    }

    @When("User enter valid mobile number")
    public void user_enter_valid_mobile_number() {
        myAccountPage.enterPhoneNumber();
    }

    @When("User enter valid pineCode")
    public void user_enter_valid_pine_code() {
        myAccountPage.enterPinCode();
    }

    @When("User enter valid area address")
    public void user_enter_valid_area_address() {
        myAccountPage.enterDoorNo();
    }

    @When("User click on submit address")
    public void user_click_on_submit_Address() {
        myAccountPage.submitAddress();
    }

    @Then("Verify added address")
    public void verify_added_address() {
        System.out.println("submited");
    }


}
