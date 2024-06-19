package com.bdd.cucumber.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

public class Demo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
        wait.until(new Function<WebDriver, Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return driver.findElement(By.id("id"));
            }
        });


        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
        }


        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id(""))).contextClick();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(500)");
    }
}
