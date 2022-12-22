package com.definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubscriptionsDetailsDefinitions {
	
    private static WebDriver driver;       
    public final static int TIMEOUT = 10;
     
    @Before
    public void setUp() {
 
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    @Given("User navigates to stctv Home page {string} and clicks on {string} language")
    public void navigateToHomePage(String url, String language) {
         
        driver.get(url);
        driver.findElement(By.xpath("//a[@id='translation-btn' and contains(text(),'"+ language +"')]")).click();
 
    }
    
    
    @And("User clicks on country as {string} verifies {string}, {string} and {string} subscription details with currency")
    public void verifyPackagesPriceWithCurrency(String country, String liteExpected, String classicExpected, String premiumExpected) {
    	
         driver.findElement(By.id("country-btn")).click();
         driver.findElement(By.xpath("//span[contains(@id,'contry-lable') and contains(text(),'"+ country +"')]/parent::a")).click();
  
         String Actual = driver.findElement(By.id("currency-lite")).getText();
         Assert.assertTrue(Actual.contains(liteExpected));
         
         Actual = driver.findElement(By.id("currency-classic")).getText();
         Assert.assertTrue(Actual.contains(classicExpected));
         
         Actual = driver.findElement(By.id("currency-premium")).getText();
         Assert.assertTrue(Actual.contains(premiumExpected));
    }
    
    @After
    public void teardown() {
  
        driver.quit();
    }
}
