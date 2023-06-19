package com.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TitleCheckAfterLogin {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }


    @Test

    public void titleComparison() {

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.click();
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();


        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is " + actualTitle);
    }



    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
