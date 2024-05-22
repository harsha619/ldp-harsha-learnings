package com.amazon.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

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
    public  void waitForCityName(WebElement element,String stateName){
        Wait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
        wait.until(new Function<WebDriver, Object>() {

            @Override
            public Object apply(WebDriver driver) {
                Select select= new Select(element);
                if(select.getFirstSelectedOption().getText().equals(stateName))
                {
                    System.out.println("done");
                    return  select.getFirstSelectedOption().getText();
                }
                return null;
            }
        });
    }
}
