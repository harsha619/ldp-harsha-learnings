package com.amazon;

import com.amazon.PageObjects.AuthenticationPage;
import com.amazon.PageObjects.MyAccountPage;
import com.amazon.PageObjects.NavigationPage;
import com.amazon.PageObjects.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginFlow {
    WebDriver driver;
    @Parameters({"BASE_URL"})
    @BeforeSuite
    public void setUp(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    @Test
    public  void login() throws InterruptedException {
        String title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

        Assert.assertEquals(driver.getTitle(),title);
        AuthenticationPage authenticationPage= new AuthenticationPage(driver);
        authenticationPage.login();
        authenticationPage.verifyOtp();


        ProductPage productPage= new ProductPage(driver);
        NavigationPage navigationPage= new NavigationPage(driver);
        MyAccountPage myAccountPage= new MyAccountPage(driver);

        navigationPage.selectMobiles();
        productPage.clickOnPrime();
        productPage.getDelivery();
        myAccountPage.getMyOrders();
        myAccountPage.getMyPayments();
        myAccountPage.getMyAddress();
        myAccountPage.fillAddressForm();

    }
}
