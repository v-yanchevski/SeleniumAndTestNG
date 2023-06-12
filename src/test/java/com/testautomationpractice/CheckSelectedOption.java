package com.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckSelectedOption {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void verifySelectedOption() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();

        WebElement option1 = driver.findElement(By.cssSelector("option[value=\"1\"]"));
        WebElement option2 = driver.findElement(By.cssSelector("option[value=\"2\"]"));

        option1.click();
        if (option1.isSelected()) {
            System.out.println("Option one is selected");
            Assert.assertTrue(true);
        } else {
            System.out.println("Option one is not selected");
            Assert.fail("Option one is not selected");
        }
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
