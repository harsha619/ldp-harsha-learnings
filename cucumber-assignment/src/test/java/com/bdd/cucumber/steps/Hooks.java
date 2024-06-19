package com.bdd.cucumber.steps;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.get("https://www.amazon.in");
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {

            driver.quit();
            driver = null;
        }
    }
}
