package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckMouseHover {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void mouseHover() {

        Actions act = new Actions(driver);

        WebElement image = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        act.moveToElement(image).build().perform();

        String userName = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();

        Assert.assertEquals(userName, "name: user1", "User name should be name: user1");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
