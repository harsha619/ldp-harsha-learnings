package com.amazon.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AbstractComponent {
    WebDriver driver;
    public  AbstractComponent(WebDriver driver){
        this.driver=driver;
        initProperties();
    }
    public Properties properties;

    public void initProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/com/amazon/config/config.properties");
            this.properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void waitForElement(By element){
        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public  void waitForWebElement(WebElement element){
        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
