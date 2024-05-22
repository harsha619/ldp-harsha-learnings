package com.amazon;


import com.amazon.PageObjects.DealsPage;
import com.amazon.PageObjects.CartPage;
import com.amazon.PageObjects.NavigationPage;
import com.amazon.PageObjects.ProductPage;
import net.bytebuddy.build.Plugin;
import org.checkerframework.checker.signature.qual.PrimitiveType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class WithoutLoginFlow {
    private static final Logger log = LoggerFactory.getLogger(WithoutLoginFlow.class);
    WebDriver driver;
    @Parameters({"BASE_URL"})
    @BeforeTest
    public void setUp(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.get(url);
    }

    @Test(priority = 1)
    public void addingItemToCart() throws InterruptedException {

        String title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

        Assert.assertEquals(driver.getTitle(),title);
        DealsPage dealsPage = new DealsPage(driver);
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/deals?ref_=nav_cs_gb']")).isDisplayed());
        dealsPage.todayDeals();
        Assert.assertTrue(driver.findElement(By.cssSelector("span#productTitle")).isDisplayed());
        cartPage.displayProductDetails();
        cartPage.addToCart();

        Select select= new Select(driver.findElement(By.id("quantity")));
        log.info("checking the cart quantity");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1");
    }
    @Test(priority = 2)
    public  void mobileSearch() throws InterruptedException {
        ProductPage productPage= new ProductPage(driver);
        NavigationPage navigationPage= new NavigationPage(driver);
        productPage.searchForProduct();
        navigationPage.selectMobiles();
        productPage.clickingOnFirstBrand();

    }
}